# CHAPTER. 08

### 8.1 가독성과 유연성을 개선하는 리팩토링 
-> 쉽게 이해, 유지보수

    * 익명클래스 -> 람다 표현식으로 리팩토링 -> 메서드 레퍼런스로 리팩토링
    * 명령형 데이터 처리 -> 스트림으로 리팩토링

#### 8.1.1 익명클래스를 람다 표현식으로 리팩토링

  * 익명클래스를 람다 표현식으로 구현하지 못하는 경우
  
  ①	익명클래스와 람다의 this, super은 서로 다른 의미
    
        익명클래스의 this: 익명 클래스 자신
        람다의 this: 람다를 감싸는 클래스
        
 ~~~
 public class MyTestClass {
    public void foo() {
 
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                System.out.println(this.toString());
                return s.length();
            }
        };
 
 
        Function<String, Integer> function2 = s -> {
            System.out.println(this.toString());
            return s.length();
        };
    }
}

 ~~~
 
 
   ②람다 표현식내에서 은닉 변수을 허용하지 않는다.
   ~~~
   public void foo() {
    Integer number = 100;
    
    Function<String, Integer> function = s -> {
        Integer number = 100; //compile Error
        return number;
    };
}

   ~~~
   
   
   ③시그니처를 갖는 함수형 인터페이스 선언 시 명시적 형변환 생략하면 오버로딩에 따른 모호함.
   ~~~
   interface Task {
    void execute();
}
 
interface Work {
    void process();
}
 
public static void action(Task task) {
    task.execute();
}
 
public static void action(Work work) {
    work.process();
}
 
public void foo() {
    
    action(new Task() {
        @Override
        public void execute() {
            System.out.println("Hi");
        }
    });
    
    action(()-> System.out.println("Hi")); //Task? Work? Ambiguous !
    action((Task) () -> System.out.println("Hi"));
 
}

   ~~~
   
   #### 8.1.2 람다 표현식을 메서드 레퍼런스로 리팩토링
   ~~~
   Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = 
menu.stream()
.collect(groupingBy(Dish::getCaloricLevel));
   // 람다 표현식을 메서드로 구현
   // Dish 클래스에 getCaloricLevel추가

   ~~~
   
   -comparing과 maxBy 같은 정적 헬퍼 메서드를 활용하는 것도 좋은 방법
   ~~~
   inventory.sort(comparing(Apple::getWeght)); //  코드가 문제 자체를 설명
   ~~~

   -sum, maximum등 자주 이용하는 리듀싱 연산은 메서드 레퍼런스와 함께 사용할 수 있는 내장 헬퍼 메서드를 제공한다.
  ~~~
int totalCalories = menu.stream().map(Dish::getCalories)
.reduce(0, c1 -> c1 + c2);

int totalCalories =menu.stream()
.collect(summingInt(Dish::getCalories));
//내장 컬렉터를 이용하면 코드 자체로 문제를 더 명확하게 설명할 수 있다

  ~~~

#### 8.1.3 명령형 데이터 처리를 스트림으로 리팩토링

 -스트림 API는 데이터 처리 파이프라인의 의도를 더 명확하게 보여준다. 
    
-스트림은 쇼트서킷과 게으름이라는 강력한 최적화와 멀티코어 아키텍처를 활용할 수 있게 제공된다. + 쉽게 병렬화 할 수 있다.

Cf) 쇼트서킷(short circuit): 표현문이 실행 되는 중에 결과가 결정되었을 때 멈추는 것.

if (a == b || c == d || e == f) {~~~}   ( a==b가 true인 경우 멈춤)=>( &&,  || (논리 연산자)인 경우)

~~~
//필터링 추출, 두 가지 패턴의 명령형 코드를 쉽게 구현할 수 있음.
menu.parallelStream()
     .filter(d -> d.getCalories() > 100 )
 .map(Dish::getName)
 .collect(toList());

~~~

#### 8.1.4 코드 유연성 개선
①	조건부 연기 실행 패턴
~~~
if( logger.isLoggable(Log.FINER)){
    logget.finer("Problem :" + getnerateDiagnostic());
    }
    // 위 코드의 문제
    // 1. logger상태가 isLoggerable이 라는 메서드에 의해 클라이언트 코드로 노출된다
    // 2. 메세지를 로깅 할때마다 logger객체의 상태를 매번확인하는것은 코드를 어지럽힐 뿐

~~~
=>
~~~
logger.log(Level.FINER, "Problem : " + generateDiagnostic());
//내부적으로 확인하는 log메서드를 사용하는것이 바람직함.
~~~
~~~
public void log (Level level, Supplier<String> msgSupploer){
    if(logger.isLoggable(level)){
    log(level, msgSupplier.get()); //람다 실행
    }
   }

~~~
	Logger 수준을 FINER로 설정한 특정 조건에서만 메시지가 생성되도록 
메시지 생성과정을 연기(defer)해야함.

	Logger 문제 해결하도록 Supplier를 인수로 갖는 오버로드된 log메소드를 제공함.


②	실행 어라운드 패턴
  -자원을 처리하는 코드를 설정(setup)과 정리(cleanup) 두 과정이 둘러싸는 형태(3장 참조)
  
  ### 8.2 람다로 객체지향 디자인 패턴 리팩토링하기
  
  #### 8.2.1 전략 패턴 (스트래터지)
  -전략을 쉽게 바꿀 수 있게 한 디자인 패턴
  
  #### 8.2.2 템플릿 메소드 패턴
	-전체적으로는 동일하지만 부분적으로 다른 구문으로 구성된 메소드의 코드 중복을 최소화 할 때 유용
  
	-전체 알고리즘 코드를 재사용할 경우 유용
  
   #### 8.2.3 옵저버 패턴
	-데이터 변경이 발생할 때 상대 클래스나 객체에 의존하지 않으면서 데이터 변경을 통보할 때 유용.
  
  #### 8.2.4 의무 체인 패턴
    -어떤 객체를 생성하고 그 인스턴스에 인자값을 통해 어떤 요청을 하면 함수는 그에 대한 처리를 함

    -각종 요청에 대해서 그것을 처리 할 수 있는 객체가 존재할 때까지 연속적으로 객체를 탐사하여 요청을 처리할 수 있도록 객체를 찾아주는 패턴

    -상위의 추상클래스를 기준으로 연쇄시킬 객체들을 서로 연결해서 처리할 수 없는 요청일 경우에는 다음 객체로 다시 요청을 보내고 처리할 수 있는 객체인 경우에는 요청이 들어오면 처리함.

  #### 8.2.5 팩토리 패턴
	-객체의 생성 코드를 별도의 클래스나 메서드로 분리해 객체 생성의 변화에 대비하는 데 유용.
  
  

