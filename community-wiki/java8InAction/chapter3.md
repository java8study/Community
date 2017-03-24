# CHAPTER 3. 람다 표현식

요구사항에 효과적으로 대응하는 코드를 구현, 정의한 코드 블록을 다른 메서드로 전달
->동작 파라미터화를 사용하면 더 유연, 재사용 가능.


## *람다의 특징
1. 익명
2. 함수 (특정 클래스에 종속 X )
3. 전달 (메서드로 인수를 전달, 변수로 저장)
4. 간결성

~~~
package java8inaction.chap2;

interface Apple4{
	int test4(int a, int b);
}

class GreenApple4 {
	public void greenApple4(Apple4 apple4) {
		int num=apple4.test4(3,5);
		System.out.println("Apple number = "+num);
	}
}

public class exam4 {
	public static void main(String[] args) {

		GreenApple4 greenApple4 = new GreenApple4();
	
		greenApple4.greenApple4(new Apple4(){
			public int test4(int a,int b) {
				System.out.println("This is GreenApple");
				System.out.println("a= "+a+"/ b= "+b);
				return 8;
			}
		});

		greenApple4.greenApple4((a,b) -> {
			System.out.println("This is GreenApple!!");
			System.out.println("a= "+a+"/ b= "+b);
			return 7;
		});
	}
}
~~~

## *람다 표현식

( 파라미터 목록 ) -> 리턴타입 { 함수 바디 }

 함수의 입력값 -> 출력값
 
 Cf) -함수형 인터페이스에서 예외 처리시, 
예외를 선언하는 함수형 인터페이스를 직접 정의하거나 try-catch 블록 사용.

-람다식의 지역변수는 final로 정의/ static을 써야 변수 변경 가능.
(final: 상속 불가 또는 변할 수 없는 상수 선언 / static: 공용의 변수를 만들 때 사용되는 예약어)


## *함수 디스크립터

-인터페이스의 추상 메서드의 시그너처=> 람다 표현식의 시그너처
-시그니처를 가지는 인터페이스는 타입을 명시해야함

~~~
Interface A{ void C(); }
Interface B{ void D(); }
Public static void action(A a){  a.C();  }
Public static void action(B b){  b.D();  }
=>action(()->~~~) (X)
  action((A a)->~~~) (O)

~~~

## *실행 어라운드 패턴
 -자원을 처리하는 코드를 설정(setup)과 정리(cleanup) 두 과정이 둘러싸는 형태
 
 ~~~
 import java.io.*;
public class ExecuteAround {

	public static void main(String ...args) throws IOException{

        String result = processFileLimited();
        System.out.println(result);

	String oneLine = processFile((BufferedReader b) -> b.readLine());
	System.out.println(oneLine);

	String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
	System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))) {
            return br.readLine();
        }
    }

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))){
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
}


 ~~~
## *함수형 인터페이스 (참고-http://palpit.tistory.com/673)

@FunctopmalInterface 

 -추상 메소드가 두 개 이상이라면 Mapping이 되지 않아 에러 발생 (단, default는 예외 발생)
 
1. Predicate<T>   -> boolean 표현식을 사용하는 역할

2. Consumer <T>  -> 제네릭 형식 T 객체를 인수로 받아서 어떤 동작을 수행하는 역할(void형)

3. Function<T, R>  -> 제네릭 형식 T를 인수로 받아 제네릭 형식 R 객체를 반환하는 역할
 
4. Supplier<T>    -> 실행 후 호출한 곳으로 데이터를 리턴하는 역할


 
