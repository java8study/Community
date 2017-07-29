# Controller
## 3.3 컨트롤러

>- 컨트롤러는 MVC의 세 가지 컴포넌트 중 가장 많은 책임을 가지고 있다.

>- 사용자의 요청을 분석 후에 서비스 계층의 비즈니스 로직을 담당하는 메소드를 불러서 요청에 따른 작업을 수행 하는 과정에서, 컨트롤러의 역할은 서비스 계층의 메소드를 선정 및 파라미터 타입에 맞게 정보를 변환해주는 것이다.

>- 컨트롤러는 서비스 계층의 메소드가 돌려준 결과를 보고 어떤 뷰를 보여줘야하는지 결정해야 한다.

## 3.3.1 컨트롤러의 종류와 핸들러 어댑터

### * Servlet / SimpleServletHandlerAdapter

>- 표준 서블릿

>- 서블릿을 컨트롤러로 사용했을 때의 장점은 서블릿 클래스 코드를 그대로 유지하면서 스프링 빈으로 등록된다는 점

>- Servlet 타입의 컨트롤러는 모델과 뷰를 리턴하지 않음


##### 3-21 Servlet 타입 컨트롤러의 테스트 클래스
~~~
 package springbook.learningtest.spring.web.controllers;
 ...
 public class ServletControllerTest extends AbstractDispatcherServletTest {  
 	@Test  
 	public void helloServletController() throws ServletException, IOException {  
     setClasses(SimpleServletHandlerAdapter.class, HelloServlet.class);  
     initRequest("/hello").addParameter("name", "Spring");  
     assertThat(runService().getContentAsString(), is("hello Spring"));  
     }
 }
 @Component("/hello")
 static class HelloServlet extends HttpServlet {
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.getWriter().print("Hello" + name);
  }
 }
~~~

### * HttpRequestHandler / HttpRequestHandlerAdapter

>- 인터페이스로 정의된 컨트롤러 타입, 아래의 인터페이스를 구현해서 컨트롤러로 만듬
>- HttpRequestHandler는 모델과 뷰 개념이 없는 Http 기반의 RMI와 같은 로우레벨 서비스를 개발할 때 이용할 수 있다.

#### 3-22 HttpRequestHandler

~~~
 package org.springframework.web;
 
 public interface HttpRequestHandler {
   void handlerRequest(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException;
}
~~~

#### * Controller / SimpleControllerHandlerAdapter
>- 인터페이스로 정의된 컨트롤러 타입, 아래의 인터페이스를 구현해서 컨트롤러로 만듬
>- 스프링 MVC의 가장 대표적인 컨트롤러 타입


#### 3-23 Controller 인터페이스
~~~
 package org.springframework.web.servlet.mvc;
 ...
 
 public interface Controller {
  ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse 
    response ) throws Exception;
 }
~~~

#### * AnnotationMethodHandlerAdapter
>- 컨트롤러의 타입이 정해져 있지 않다. (제한이 없음)
>- 컨트롤러 하나가 하나 이상의 URL에 매핑될 수 있다.
>- DefaultAnnotationHandlerMapping 핸들러 매핑과 함께 사용해야 한다.

#### 3-27 애노테이션 방식의 컨트롤러
~~~
@Controller
public class HelloController {

 @RequestMapping("/hello")
 public String hello(@RequestParam("name") String name, ModelMap map ) {
  map.put("message", "Hello" + name );
  return "/WEB-INF/view/hello.jsp";
   } 
}
~~~

## 3.3.2 핸들러 매핑
>- HTTP 요청 정보를 이용해서 이를 처리할 핸들러 오브젝트, 즉 컨트롤러를 찾아주는 기능을 가진 DispatcherServlet의 전략이다.
>- 하나의 핸들러 매핑 전략이 여러 가지 타입의 컨트롤러를 선택할 수 있다.
>- 다섯 가지 핸들러 매핑을 제공(스프링)    

>- BeanNameUrlHandlerMapping
>- ControllerBeanNameHandlerMapping
>- ControllerClassNameHandlerMapping
>- SimpleUrlHandlerMapping
>- DefaultAnnotationHandlerMapping

## 3.3.3 핸들러 인터셉터
>- DispathcerServlet이 컨트롤러를 호출하기 전과 후에 요청과 응답을 참조하거나 가공 할 수 있는 일종의 필터 (서블릿 필터와 유사한 개념)

#### 3-32 핸들러 인터셉터 설정
~~~
 <bean class="org.springframwork.web.servlet.handler.BeanNameUrlHandlerMapping">
   <property name="interceptors">
     <list>
       <ref bean="simpleInterceptor" />
       <ref bean="eventInterceptor" />
    </list>
 </property>
 </bean>
 
 <bean id="simpleInterceptor" class="..."/>
 <bean id="eventInterceptor" class="..." />
~~~

#### * HandlerAdapter
#### 3-33 HandlerAdapter

~~~
package org.springframework.web.servlet;
...
public interface HandlerAdapter{
 boolean supports(Object handler);
 
 ModelAndView handler(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception;
            
 long getLastModified(HttpServletRequest request, Object handler);
   
}
~~~

## 3.4.1 뷰
-> MVC 아키텍처에서 모델이 가진 정보를 어떻게 표현해야하는지에 대한 로직을 갖고 있는 컴포넌트
#### 3-40 View 인터페이스
~~~
package org.springframework.web.servlet;
...
public interface View {
 String getContentType();
 
 void render(Map<String, ?> model, HttpServletRequest request, 
  HttpSErvletResponse response) thorws Exception;
}
~~~

>- InternalResourceView
>- JstlView

>- RequestDispatcher 를 이용한 JSP뷰 생성
~~~
req.setAttribute(“message”, message);
req.getRequestDispatcher(“/WEB-INF/view/hello.jsp”).forward(req, res);
~~~

>- InternalResourceView 의 사용
~~~
public class HelloController implements Controller {
...
public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
Map<String, Object> model = new HashMap<String, Object>();
model.put("message", message);

View view = new InternalResourceView("/WEB-INF/view/hello.jsp");
return new ModelAndView(view, model);
	}
}
~~~  

>- RedirectView
~~~
return new ModelAndView(new RedirectView("/main");

return new ModelAndView("redirect:/main");

~~~

>- Velocity View
>- FreeMarker View
>- MarshallingView
>- AbstractAtomFeedView
>- AbstractRssFeedView
>- AbstractExcelView
>- AbstractJExcelView
>- AbstractPdfView

#### 3-48 엑셀 문서 생성 코드
~~~
protected abstract void buildExcelDocument {
 Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception;
}
~~~

#### 3-49 PDF 뷰

~~~
public class HelloPdfView extends AbstractPdfView {
 protected void buildPdfDocument(Map<String, Object> model, Document document,
  PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
  Chapter chapter = new Chapter(new Paragraph("Spring Message"), 1);
  chapter.add(new Paragraph((String)model.get("message")));
  
  document.add(chapter);
  }
}
~~~

>- XstlView
>- TilesView
>- AbstractJasperReportsView
>- MappingJacksonJsonView


## 3.4.2 뷰 리졸버
>- 핸들러 매핑이 URL으로 부터 컨트롤러를 찾아주는 것처럼, 뷰 이름으로 부터 사용할 뷰 오브젝트를 찾아준다.
>- ViewResolver 인터페이스를 구현해서 만들어진다.

#### InternalResourceViewResolver
#### 3-53 prefix, suffix 설정을 위한 빈 등록

~~~
 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 <property name="prefix" value="/WEB-INF/view" />
 <property name="suffix" value=".jsp" />
 </bean>
~~~

>- VelocityViewResolver
>- FreeMarkerViewResolver
#### 벨로시티 뷰 설정
~~~
<bean id="velocityConfig" class="org.springframework.web.servlet.view.velocity.VelocityConfigurer">
	<property name="resourceLoaderPath" value="/WEB-INF/velocity/">
</bean>

<bean id="viewResolver" class=org.springframework.web.servlet.view.velocity.VelocityViewResolver">
~~~
                                                                                                 
>- ResourceBundleViewResolver
>- XmlViewResolver
>- BeanNameViewResolver

~~~
view.properties 파일
hello.(class)=org.springframework.web.servlet.view.JstlView
hello.url="WEB-INF/view/hello.jsp

main.(class)=org.springframework.web.servlet.view.velocity.VelocityView
main.url=main.vm
~~~

#### 다중 뷰 리졸버 설정 
~~~
<bean class="org.springframework.web.servlet.view.ResourceBundleViewResolver">
	<property name="order" value="0" />
</bean>

<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"/>
~~~
#### ContentNegotiatingViewResolver

-> 뷰의 종류를 선택하는 컨트롤러 코드
~~~
if ("xml".equals(req.getParameter("type"))) {
	return new ModelAndView(helloMarshallingView, model);
}
else {
	return new ModelAndView("/WEB-INF/view/hello.jsp", model);
}
~~~

























 

