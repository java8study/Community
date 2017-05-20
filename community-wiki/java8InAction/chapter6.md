# CHAPTER. 06
#### 6 컬렉터
-> 무엇을 원하는지 직접 명시하여 어떤 방법으로 얻을지 신경 쓸 필요가 없게 된다. 
그동안 작업한 collect(toList()) / collect(groupingBy()) 등	 리듀싱 연산이 내부적으로 수행 된다.

  * 값으로 스트림 만들기
    -> Stream<String> strem = Stream.of(“Java 8”, “Lambdas”, “In”, “Action”);



#### 6.2.1 스트림값에서 최댓값과 최솟값 검색
-> Collectors.maxBy / Collectors.minBy 두 개의 메서드를 사용

  * Collectors.maxBy
    -> Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
	Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloreisComparator));
	
	maxBy 컬렉터는 스트림 요소 비교를 위해 Comparator 인수로 받는다.



#### 6.2.2 요약 연산
-> Collectors.summingInt 라는 특별한 요약 메서드를 제공한다. int 로 매핑하는 함수를 인수로 받는다. 
Collectors.summarizingInt 는 최대 / 평균 / 합계 등 두 개 이상의 연산을 한 번에 수행하기 위한 메서드

  * Collectors.summingInt
    -> int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

  * Collectors.summarizingInt 
    -> IntSummarStatics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
	=> IntSummaryStatistics { count = 9, sum = 4300, min = 120, ... }



#### 6.2.3 문자열 연결
-> 내부적으로 StringBuilder 를 이용하여 문자열을 연결하는 joining 팩토리 메서드

  * joining
    -> String shortMenu = menu.stream().map(Dish::getName).collect(joining());
  * 내부적으로 toString 메서드를 포함하면 생략이 가능하다.
  => String shortMenu = menu.stream().collect(joining());



#### 6.2.4 범용 리듀싱 요약 연산
-> 모든 컬렉터는 reducing 팩토리 메서드로 구현이 가능하다.

  * reducing
    -> 세 개의 인수를 받는다.
	A. 리듀싱 연산의 시작값 이거나 스트림에 인수가 없을 때의 반환값
	B. 변환 함수 (요리를 칼로리 정수로 변환하는 Dish::getCalories)
	C. 같은 종류의 두 항목을 하나의 값으로 더하는 BinaryOperator
