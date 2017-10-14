4.8 URL과 리소스 관리

디폴트 서디풀트서블릿과URL 매핑문제

URL을 통해 접근할 수 이는 웹을 분류하면

    정적리소스: html,js, css
    동적인: jsp, 스프링mvc

%  URL은 동적인것과 정적인것을 구분하지 않고, 경로와 이름을 조합

    .do 같은 확장자로 했지만 최근에는 확장자 없이 /user/add , /user/1/edit 등과같이 사용

    1 확장자를 쓰는 예전방식
    	<servlet>
    	<servlet-name>appServlet<lservlet-name>
    	<servlet-class>Org.springframework .web.servlet .DispatcherServlet<servlet-class>
    	<Isevlet>
    	<servlet-mapping>
    	<servlet-name>spring<lservlet-name>
    	<servlet-name)*.do</servlet-name>
    	</servlet>
    
    2. 확장자를 안쓰는 요즘방식
    
    	<servlet>
    	<servlet-name)spring<lservlet-name>
    	<servlet-name)/app/*</servlet-name>	
    	</servlet-mapping>

?: 2와 같은 방식이라면 js, css 같은 파일을 어떻게 구분하는 것인가면 web.xml에 확장자설정이 되어있다.

    	<servlet>
    	<servlet-name>default<lservlet-name>
    	<servlet-class>Org .apache .catalina.servlets.Default5ervlet<lservlet-class>
    	<load-on-startup> l</load-on-startup>
    	</servlet>
    
    
    	<servlet-mappin>
    	<servlet-name>default<lservlet-name)
    	<url-pattern)/</url-pattern>
    	</servlet-mapping>
    
    
    
    	<servlet>
    	<servlet-name>isp</servlet-name>
    	<servlet-class>Org.apache.iasper.servlet.JspServlet</servlet-class>
    	< load-on-startup>3<load-on-startup>
    	</servlet>
    
    	<servlet>
    	<servlet-name>isp</servlet-name)
    	<url-pattern>*.isp</url-pattern)
    	<url-pattern>*.ispx</url-pattern)
    	</servlet-mapping>
    
    



jsp서블릿은 JspServlet으로 보내주고 나머지는 우선순위가 낮은 /로 보냄



mvc:default-servlet-handler/

?: DispatcherServlet에 /로 매핑해버리면 web.xml에 설정된 DefaultServlet보다 우선시 됨

문제 해결은 다음과 같음

-> 서블릿 콘텍스트에 mvc:default-servlet-handler/를 넣으면 됨

   디스패처 서블릿으로 가는 것 같지만, 정적리소스파일에 대한 요청을 디폴트 서블릿으로 가게해줌



4.8.2 (url:resource/)를 이용한 리소스관리

url:resource를 사용하면 정적파일도 라이브러리처럼 쓸 수 잇음

-> 모듈화된 리소스를 다루는 별도의 서블릿 만듬

메타정보나 리소스가 있으면 /META-INF에 다음과 같은 구조로 넣어주면 된다.

 META-INF/ webresources / ui /  js

                                 / css
                                 / theme

서블릿 컨텍스트에 <mvc:resources mapping="/ui/** location="classpath:/META-INF/webresources"/  /> 추가

이렇게 해두면 /ui로 시작되는 요청이 들어왔을 경우 자동으로 webresources 아래의 파일로 매핑해줌

- 1. location 애트리부트에 file, http를 넣으면 다른서버의 정보를 가져올 수 있음
- 1. 1. 이미 등록해 놓은 리소스면 304코드를 보내 효율성을 높일 수 잇음

일부만 <mvc:resouces를 사용하고 나머지는 디폴트 서블릿을 사용 할 때는 <mvc:default-servlet-handler>를 사용하면 recources로 매핑이 안되는것만 디폴드로 보냄

mvc:resources는mvc:default-servlet-handler 보다 매핑 우선순위가 높다 .

4.9.1 새로운 RequestMapping 전략

636~636 기존의 리퀘스트 매핑은 문제점에대해 설명

스프링 이전 단계에서는 컨트롤 단위로 매핑했지만,  2.5부터 추세에 따라 메소드 단위로 매핑 가능해짐

그렇게 됨으로써 핸들러레벨의 매핑이 어려움, 메소드는 오브젝트로 취급되지 않으니 빈이 될 수가 없다.  3.0에서는 해결하기 위해 DefaultAnnotationHandlerMapping 전략에선 매핑 결과가 요청을 담당할 메소드가 속해 있는 컨트롤러의 오브젝트가 될 수밖에 없었다. 그래서 선정된 핸들러를 실행하는 책임만 맡아야 할 AnnotationMethodHandlerAdapter가 필요했음, 망함

public boolean preHandle(HttpServletRequest request, HttpServletResponse response,

Object handler) throws Exception; 

위에 것은 핸들러 인터셉턴인데 저기서 핸들러는 요청을 처리할 메소드의  메타정보를 얻을 수 있는데 컨트롤러 오브젝트 전체가 핸들러 매핑되버리니 정보를 얻을 수 없음.

- 결론적으로 핸들러 매핑과 어댑터 전략은 mvc핸들러가 컨트롤러 역활을 담당하는 빈 오브젝트라는 설계의 전제와, 메소드를 실행 가능한 핸들러 오브젝트 형태로 만들 수 없어서 이상할 수 밖에 없음



-> 3.1부터는 전달받은 핸들러를 HandlerMethod 타입으로 캐스팅하여 해결함

    리스트 4-129 @Audit 애노테이션이 달린 @RequestMapping 메소드를 처리하는 핸들러 인터셉터
      @Autdit 애노테이션이 붙어있는 @Request메소드가 실행될 때마다 관련 정보를 파일에 저장
    public class Auditlnterceptor extends HandlerlnterceptorAdapter {
    @Override
      public boolean preHandle(HttpServletReQuest reQuest ,
      HttpServletResponse response, Object handler) throws Exception {
    
          HandlerMethod hm =(HandlerMethod)handler;
      if (hm .getMethodAnnotation(Audit .class) != null) {
    		saveAuditlnfo(reQuest, response, handler);
    	}
    	return super.preHandle(reQuest, response , handler);
    }
    	private void saveAuditlnfo(HttpServletReQuest reQuest ,
    	HttpServletResponse response , Object handler) {
    
    	// 요청정보를 감사 용도의 외부 파일에 저장
    	}
    }

- HandlerMethod

HandlerMethod는 @RequestMapping 이 붙은 메소드의 정보를 추상화한 오브젝트 타입

이다.  컨트롤러 오브젝트 대신 추상화된 메소드 정보를 담은 오브젝트를 핸들러 매핑의

결과로 돌려주고，핸들러 어랩터는 HandlerMethod 오브젝트의 정보를 이용해 메소드를

실행한다.  * 실제 실행x 정보를 담고있는거 o

 % 그리고 실제로 쓰는 일도 없다고 한다. 

- 핸들러 메소드의 정보들

1.    빈 오브젝트
2.  메소드 메타정보
3.  메소드 파라미터정보
4. 메소드 애노테이션메타 정보
5. 리턴 값 메타정보
   
   