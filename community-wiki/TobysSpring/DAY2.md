# 1장.	IoC 컨테이너와 DI
## 1.2.3 빈 의존관계 설정 방법(빈 설정) 
### * 의존관계 설정방법 분류
~~~
:분류 
    선정방법
	- (1) 명시적으로
		빈을 직접 지정
	- (2) 방법과 일정한 규칙으로 
		타입 비교를 통해 호환 되는 걸 찾은 autowired라고 부름
   메타정보 작성방법
	- (1) xml 빈 태그, 스키마를 가진 전용 태그, 어노테이션, 자바코드
		
     이걸 다시 명시적으로 빈을 지정하는걸로 나눠서 총 8개로 나뉨
		  혼용가능하니 상황에 따라 잘 써야함 자세한 내용은 아래에

~~~

###  메타정보 작성 방법                
#### 1. xml을 이용하는 방법
~~~
*One ! <bean>과 <property> 등 각 태그 등을 사용

1. <property>의 속성들
   	   - ref는 이름을 통해 다른 빈을 주입, 해당 빈이 등록되어 있어야함
    	   - value는 단순 값이나 빈이 아닌 오브젝트 주입
            xml이다 보니 “”를 붙여야 하는데 첫 번째로는 스트링타입으로 들어감 
            내장 변환기를 이용해 알맞은 타입으로 변경해줌
2. <constructor-arg> 
      - ex) <constructor-arg index="0" value="값 이름" or ref="빈 이름"> 
      - 생성자를 이용한 주입 할 때 사용
      - 여러 개를 넣을 때는 순서를 맞춰서 넣어주면 됨

3. xml 자동와이어링  
      - ex) <bean id="아이디“ autowire="byName" or "byType">
      - 이름이나 타입에 따라 프로퍼티를 자동으로 지정해줌, 두 가지 방법이 있다.
                   - by name: 이름 넣는 게 힘듬, 성능이 좋음
                   - by type: 모든 규칙에 따라 이름 넣기가 힘들 때 넣으면 좋음
                          성능 후지고, 타입이 같은 빈이 두 개 있으면 쓰기 못 씀
    
 
*Two ! xml 네임스페이스와 전용태그

- aop나 database 같이 특정이름이 있는 것을 전용태그라고 함. ex( <oxm:
-<property>나 <construtor-arg>라는 di용 태그가 고정 되어있지
   않아서 의존관계 지정이 단순하지 않음,
- 일반 빈을 주입 할 수 있고 빈의 ref로 주입 당할 수도 있음. 
     
~~~          
### 2. 클래스에 annotation을 이용하는 방법

~~~
*1 ! @Resource : 필드와 메소드에 적용 할 수 있음
    - 수정자에 @Resource(name="빈 이름") 로 사용 할 수 있음
    - 참조할 빈은 @Resource를 붙인 메소드의 이름을 따라서 자동으로 붙음
    - 사용하려면 다음 세 가지 방법 중 하나를 선택 해야한다.
        1. 'XML의<context:annotation-config />
           - <context:annotation-config />는 새로운 빈을 추가 시켜주는 게 아니라
                 메타 데이터를 자동 생성 시켜주는거 <property> 같은 프로퍼티
       2. 'XML의<context:component-scan base-package=""/>
           - 이거는 bean까지 자동으로 추가시켜 줌 대신 빈 스캐닝을 위해
	       클래스에  @Conmponent를 붙여줘야 함. base 패키지 밑에 다 적용 됨 
        
       3. AnnotationConfigWebApplicationContext
		
	   자바에서 xml 설정을 가져와 사용하는 것

*2 ! @Resouce 필드 적용 
        ex)  @Resource(name="참조할 빈 이름")
              private Printer printer
       - 이름을 생략할 경우 필드의 이름으로 빈을 찾음, 없을 경우 타입으로도 찾음
       - 참조할 빈을 못찾으면 에러 발생 함
          
~~~
### 3. @Autowired / @Injection
~~~
 - 어노테이션 Resouce와 비슷하게 앞에 입력하면 자동으로 주입해줌
 - Resource와  달리 생성자에도 적용할 수 있음 하나의 생성자 밖에 적용 안되서
   수정자에 적용하는 것이 좋다.
 - Collation,Map,List 에도 적용 가능 함
 - 타입으로 구분하는데 타입이 같다면 @Qualifier를 적용하면 됨, 
 - 이름으로 구분해야 한다면 Resource 사용
 - Autowired / injection 차이는 Autowired는 스프링기반 injection은 자바기반
~~~
### 자바기반 빈 설정 
~~~
@Bean과 @Configuration을 이용
  ex) @Configuration   
      class 클래스명 {
   	 @Bean public Hello hello() { return hello;
 - 자바로 만들어도 xml로 만든 bean과 상호 작용이 가능 함.        

~~~
### 4. 빈 의존관계 설정전략
~~~
! 여태까지 배운방법으로 여러 가지 조합을 할 수 있음
1. xml 단독
   - 모든 걸 다 xml에서 하는 거, 작가는 ByName 오토와이얼드가 좋다고 함
2. xml이랑 어노테이션 조합
   - 빈 등록은 xml로 하고, @Autowired나 @Resource를 통하여 이용하는 방법
3. 어노테이션 단독
   - 	   빈의 등록도 @COMPONET로 하고 의존관계도 어노테이션으로 하는 것
	   위 두 방법 보다 생산성이 높고 수정이 편리하다고 해 비중이 늘어나고 있다고 함
	   일부 기술은 xml을 이용 할 수 있다. xml없이 순수한 자바코드만으로 설정 하고
	   싶을 경우 @Configuration을 이용하면 됨


~~~
## 1.2.4 프로퍼티 값 설정
~~~
- DI를 통해 빈에 주입 되는 것은 두가지
 1. 빈 2. 빈이 아닌 단순 값(스프링에 등록 된 빈 말고 복잡한 오브젝트도 단순 값으로 주입 됨)
- 빈은 싱글톤(하나만 생성되서 공유)이기 떄문에 함부로 상태값을 수정해서는 안됨,
   필드에 있는 값은 대부분 초기값이고 읽기전용이다
~~~
### 메타 정보 종류에 따른 값 설정 방법
#### 1. xml:<property>와 전용태그
~~~
 -ref 애트리뷰트를 이용해 다른 빈의 아이디를 지정한다.
~~~
#### 2. @Value
~~~
 - 외부에서 값을 가져와야 할 때 사용한다.
 - 초기값을 갖고 있지만 특별한 이벤트에 의해서 값이 변하는 것
 - ex @Value("${database.username}")
~~~
#### 3. properyEditor와 ConversionService
~~~
- value는 다 스트링 값으로 들어감, 다른 타입으로 넣고 싶을 때는 변환 해주어야한다.
- int,char,short,float 등등 기타 기본 타입들은 스프링이 자동으로 변환해줌
 - ConversationService 는 멀티스레드 환경에서 지원해준다.
~~~
#### 4.컬렉션
~~~
1) 프로퍼티에 컬렉션 종류의 밸류나  레퍼런스를 넣는법
 - ex) <propery name="">
         <list>
          <value> </value>  // <ref bean=""/> 
	   </list> %list 대신 map, props도 가능
         
2) 리스트를 프로퍼티 말고 자체적인 빈으로 생성하는 법
   -ex) <util:map id=ages map-class="클래스" >
         <entru key ="" value=""/>

   -ex) <util:property id=""  location="">
          <prop key ="" >asdad </prop> 

   -ex) <util:list id="" list-class="java.util.LinkedList">
          <value> asdad </value>
   - null값은 <value> <null/> 로 넣을 수 있음
~~~

#### 5. 외부에서 값 가져오기
~~~
database.property 가 있을 경우 내용
    (db.username=spring)

*1 <context:property-placeholder>이용
- <context:property-placeholder location="classpath:database.properties"/>
- <property name="username" value="${db.username }" />넣어주면 된다.
- @Value( "$ {db .username }") String username; 로 사용가능하다.


*2  spell
- 다른 빈 오브젝트에 접근 할 수 있는 표현식을 이용해 원하는 오브젝트를 능동적으로 가져오는 것
사용방법
 1. <util:properties id="dbprops" location=“classpath:database.properties" /> 로 
    프로파티 파일의 내용을 가진 properties 타입의 빈을 만들어주고
    

2. <property name='driverClass" value='# {dbprops ['db.driverclass' l) ‘ /> 로 넣을 수 있음 
  
- value에도 가능
- 에러 검증 가능
~~~

## 1.2.5 컨터에너가 자동으로 등록하는 빈
스프링 컨테이너가 초기화 과정에서 자동으로 등록해주는 빈

### 1. ApplicationContext, BeanFactory
~~~
-스프링 컨테이너인 애플리케이션 컨텍스트는 ApplicationContext 인터페이스를 구현한 것임
ex) 	@Autowired ApplicationContext context;
      public void specialJobWithContext( ) (
		this.context.QetBean( ... )
~~~
### 2. ResourceLoader, ApplicationEventPublisher
 ~~~
- 스프링은 서버환경에 따라 다양한 Resource를 로딩할 수 있는 기능을 제공함. 코드를 통해 서블릿 콘텍스트의 리소스를 읽어오고 싶다면 컨테이너를 ResouceLoader 타입으로 di 받아서 사용하면 됨. 
@Autowired ResourceLoader resourceLoader;

 public void loadDataFile() {
	Resource resource = this.resourceLoader .getResource("WEB-INF/info.dat");

~~~
### 3. systemProperties, systemEnvironment
~~~
- 이름으로 접해야 함
@Resource Properties systemProperties;
@Value( “#(systemProperties['os.name')J") String osName;
~~~
