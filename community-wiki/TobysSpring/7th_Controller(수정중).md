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
~~~


