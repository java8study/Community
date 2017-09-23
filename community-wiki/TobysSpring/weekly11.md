#4.8 URL과 리소스 관리 #
##디폴트 서디풀트서블릿과URL 매핑문제
...
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



###(mvc:default-servlet-handler/>###

?: DispatcherServlet에 /로 매핑해버리면 web.xml에 설정된 DefaultServlet보다 우선시 됨
문제 해결은 다음과 같음

-> 서블릿 콘텍스트에 <mvc:default-servlet-handler/>를 넣으면 됨
   디스패처 서블릿으로 가는 것 같지만, 정적리소스파일에 대한 요청을 디폴트 서블릿으로 가게해줌
 
...

#4.8.2 (url:resource/)를 이용한 리소스관리 #
...

<url:resource>를 사용하면 정적파일도 라이브러리처럼 쓸 수 잇음

-> 모듈화된 리소스를 다루는 별도의 서블릿 만듬


메타정보나 리소스가 있으면 /META-INF에 다음과 같은 구조로 넣어주면 된다.
 META-INF/ webresources / ui /  js
                                 / css
                                 / theme

서블릿 컨텍스트에 <mvc:resources mapping="/ui/** location="classpath:/META-INF/webresources"/  /> 추가

이렇게 해두면 /ui로 시작되는 요청이 들어왔을 경우 자동으로 webresources 아래의 파일로 매핑해줌
 %location 애트리부트에 file, http를 넣으면 다른서버의 정보를 가져올 수 있음
           


