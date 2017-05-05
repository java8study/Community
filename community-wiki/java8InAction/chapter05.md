# CHAPTER. 05

### 5.2 매핑 
-> 특정 객체에서 특정 데이터를 선택하는 작업, 스트림 API 의 map / flatMap

    * map 
      -> List<String> dishNames = menu.stream()
					  .map(Dish::getName)
					  .collect(toList());
             
         List<Integer> dishNames = menu.stream()
				  	.map(Dish::getName)
				  	.map(String::length) 		<- chaining 연결 가능
				  	.collect(toList());

    * flatMap (스트림 평면화) - 154p (10장 상세) 
      -> List<String> wordLengths = words.stream()
					  .map(word -> word.split(“”);
					  .map(Array::stream)
					  .distinct()
					  .collect(toList());

      	 List<String> wordLengths = words.stream()
					  .map(word -> word.split(“”);
					  .flatMap(Array::stream)	<- 하나의 스트림으로 평면화
					  .distinct()
					  .collect(toList());



#### 5.3 검색과 매칭
-> 데이터 집합에 특정 속성 여부를 검색하는 작업, 스트림 API 의 allMatch / anyMatch / noneMatch / findFirst / findAny 등

  * anyMatch (Boolean)
    -> 스트림 내 한 요소라도 일치할 때
       ex) menu.stream().anyMatch(Dish::isVegetarian)

  * allMatch (Boolean)
    -> 모든 요소가 일치할 때
    	 ex) menu.stream().allMatch(d -> d.getCalories() < 1000)

  * noneMatch (Boolean)
    -> 모든 요소가 일치하지 않는지
	     ex) menu.stream().noneMatch(d -> d.getCalories() >= 1000)

  * 위 3가지 메서드는 스트림 쇼트서킷 기법 (자바의 &&, || 와 같은 연산을 활용)
	  -> 모든 스트림 요소를 처리하지 않으므로 무한 요소 스트림을 유한한 크기로 줄일 수 있는 유용한 연산

  * findAny (Optional<T>)
    -> 스트림 내 임의의 요소 반환
    	 ex) Optional<Dish> = menu.stream().filter(Dish::isVegetrian).findAny();
	* Optional<T>: 값의 존재나 부재 여부를 표현하는 컨테이너 클래스. null 관련 버그 예방. (10장 상세)

  * findFirst (Optional<T>)
    -> 스트림 내 첫 번째 요소 반환
	* findAny 와 findFirst 두 가지 필요한 이유는 병렬성 때문. 병렬에서는 첫 번째 요소를 찾기 어려움.



#### 5.4 리듀싱
-> 스트림 요소를 조합하여 더 복잡한 질의를 표현하기 위한 작업 = 폴드 라고도 함, 스트림 API 의 reduce

  * reduce - 162p
    -> int sum = numbers.stream().reduce(0, (a, b) -> a + b);
	* 메서드 레퍼런스 사용하여 보다 간결하게 가능
	int sum = numbers.stream().reduce(0, Integer::sum);


  * 최대값 / 최소값
    -> Optional<Integer> max = numbers.stream().reduce(Integer::max);
    	 Optional<Integer> min = numbers.stream().reduce(Integer::min);
  * reduce 장점
	내부 반복이 추상화되어 내부 구현에서 병렬로 reduce를 실행



#### 5.6 숫자형 스트림
-> 3가지 기본형 특화 스트림 제공, IntStream / DoubleStream / LongStrem

  * 숫자 스트림으로 매핑
    -> int calories = menu.stream()
			    .mapToInt(Dish::getCalories)		<- 언박싱 과정 생략. IntStream 반환
			    .sum();

	* 일반 스트림으로 변환
    -> Stream<Integer> stream = intStream.boxed();		<- 숫자 스트림을 스트림으로 반환



#### 5.7 
