# CHAPTER. 09
구현 클래스 변경 없이 인터페이스에 새로운 메서드를 추가 하거나 인터페이스를 바꾸고 싶다면?

#### 1. 정적 메서드 (Static Method)

자바 8에서는 인터페이스 내부에 정적 메서드를 구현할 수 있음. 

(+ 호환성 유지를 위해 자바 API 유틸리티 클래스가 남아있음)

#### 2. 디폴트 메서드 (Default Method):

-인터페이스의 기본 구현을 그대로 상속하므로 호환성이 유지되고 새로운 메서드 추가 가능, API 변경 가능.

-인터페이스를 구현하는 클래스에서 구현하지 않은 메서드를 인터페이스 자체에서 기본으로 제공

-디폴트 메서드는 추상메서드에 해당 되지 않는다.

	추상클래스는 다중 상속 안되지만 인터페이스는 디폴트 메서드를 통해 다중 상속 가능함.  

	추상클래스는 인스턴스 변수를 가질 수 있지만 인터페이스는 인스턴스 변수(멤버변수)를 가질 수 없다.


~~~
public interface Calculator {
	public int plus(int i, int j);

	public int multiple(int i, int j);

	default int exec(int i, int j) {  // default 메소드
		return i + j;
	}

	public static int exec2(int i, int j) { // static 메소드
		return i * j;
	}
}

// 인터페이스에서 정의한 static메소드는 반드시 인터페이스명.메소드() 형식으로 호출해야한다.

public class MyCalculatorExam {
	public static void main(String[] args) {
		Calculator cal = new MyCalculator();
		int value = cal.exec(5, 10);
		System.out.println(value);

		int value2 = Calculator.exec2(5, 10); // static메소드 호출
		System.out.println(value2);
	}
}

~~~

### 9.3 디폴트 메서드 활용 패턴
  #### 9.3.1 선택형 메서드 
 -인터페이스를 구현할 때 필요 없는 추상 메서드에 대해서도 반드시 구현을 해줬어야 하므로 빈 구현을 구현했다면, 디폴트 메서드를 통해 인터페이스에서부터 구현을 해주면 쓸데없는 빈 구현 코드가 사라짐.
  ####9.3.2 동작 다중 상속
   -디폴트 메서드를 이용하면 인터페이스에는 다중 상속이 가능함
  
   -기존 코드를 재사용 할 수 있음. 


