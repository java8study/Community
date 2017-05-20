# CHAPTER. 14 함수형 프로그래밍 기법

### 함수는 모든 곳에 존재한다
  * 자바 8이 이전 버저과 구별되는 특징 중에 하나는 일급 함수를 지원한다는 것
  * :: 연산자로 메서드 레퍼런스를 만들거나 (int x) -> x + 1 같은 람다 표현식으로 직접 함숫값을 표현



### 고차원 함수
  * 하나 이상의 함수를 인수로 받는 경우
  * 함수를 결과로 반환하는 경우
ex) Function<Function<Double, Double>, Function<Double, Double>>
  * (Double x) -> x * x 라는 함수를 인수로 받아 (Double x) -> 2 * x 같은 함수를 결과로 반환



### 커링
  * 커링은 x 와 y 라는 두 인수를 받는 함수 f 를 한 개의 인수를 받는 g 라는 함수로 대체하는 기법
  * 기존 로직을 활용해서 변환기를 특정 상황에 적용하는 방법
  * 한개의 인수를 갖는 변환 함수를 생산하는 팩토리를 정의
ex) static double converter(double x, double f, double b) {
		  return x * f + b;
    }

  * 개선
    static DoubleUnaryOperator curriedConverter(double f, double b) {
		  return (double x) -> x * f + b;
    }
    DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
    DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
 
