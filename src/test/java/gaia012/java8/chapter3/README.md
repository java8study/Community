#람다

람다란?
익명함수를 단순화 한 것.

람다의 특징
익명 : 보통 메서드와 달리 이름이 없으므로 익명이라한다.
함수 : 메서드처럼 특정 클래스에 종속되지 않으므로 함수라고 부른다.
전달 : 람다 표현식을 메서드 인수로 전달하거나 변수로 저장할 수 있다.
간결성 : 심플하다.

람다의 구성
파라미터 리스트, 화살표, 람다의 바디
(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

함수형 인터페이스
하나의 추상메서드를 지정하는 인터페이스 ex) Comparator, Runnable...
디폴트 메서드가 있더라도 추상메서드가 하나면 함수형 인터페이스다.

함수 디스크립터
시그니처를 서술하는 메서드
() -> {}의 시그니처는 () -> void

함수형 인터페이스 사용
함수 디스크립터
함수형 인터페이스의 추상 메서드 시그니처
- Predicate : T -> boolean
- Consumer : T -> void****
- Function T -> R

형식검사, 형식추론, 제약

형식검사.
List<Apple> heavierThan150g = filter(inventory , (Apple a) -> a.getWeight() ) 150);

1. 람다가 사용된 컨텍스트는 무엇인가? filter 정의 확인
2. 대상형식은 Predicate<Apple>이다.
3. Predicate<Apple> 인터페이스의 추상메서드는 무엇인가?
4. Apple을 인수로 받아 boolean을 반환하는 test 메서드다.
5. 함수디스크립터는 Apple -> boolean이므로 람다의 시그니처와 일치한다.
 boolean을 반환하므로 코드 형식검사가 성공적으로 완료된다.
 
형식추론
List<Apple> greenApples = filter(inventory, a -> "green".equals(a.getColor()));
- a : Apple

지역변수사용
람다에서 사용되는 지역 변수는 명시적으로 final로 선언되어 있거나 final 변수 처럼 사용되어져야 한다.
쓰레드의 안정성을 위해서 막아놓음.

클로저
함수의 비지역 변수를 자유롭게 참조할 수 있는 함수의 인스턴스

메서드 레퍼런스(클래스명::메소드명)
Apple::getWeight == (apple a) a -> a.getWeight()

MergeTest5
MergeTest5
MergeTest5
MergeTest5
