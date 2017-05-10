Chapter 4.

- 스트림
	- 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소
	- 자바 8에서 새롭게 추가된 API
		(java.util.stream.Stream 참고)
	- 코드로 질의표현 -> 컬렉션 데이터 처리
	- 쓰레드를 이용하지 않고 병렬로 처리가능
		- ex) 
			List<String> lowCaloricDishesName = menu.stream().~
			List<String> lowCaloricDishesName = menu.parallelstream().~  => 병렬로 실행
	- 선언형 코드로 작성가능
		- filter / sorted / map / collect 같은 빌딩블록연산을 연결해 복잡한 데이터 처리 파이프라인을 만들 수 있다. (가독성, 명확성)
		 이는 특정 스레딩 모델에 제한되지 않고 자유롭게 사용가능 (단일/멀티 스레드)
		 parallelstream을 쓰면 스레드와 락 걱정을 할 필요가 없다. 알아서 해준다!
		------------------------------------------------------
		import static java.util.Comparator.comparing;
		import static java.util.stream.Collectors.toList;
			
		List<String> lowCaloricDishesName =
			menu.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(toList());
		------------------------------------------------------

		------------------------------------------------------
		Map<Dish.Type , List<Dish>> dishesByType =
			menu .stream() .collect(groupingBy(Dish : :getType));
		------------------------------------------------------
	* 요약 -> 선언형, 조립, 병렬화
	- 기능 : 
		필터링
		슬라이싱
		검색
		매칭
		매핑
		리듀싱...
	- 스트림의 주제는 계산이다.
	- 스트림 연산끼리 연결해서 파이프라인 구성가능
	- 스트림과 컬렉션의 차이
		데이터를 언제 계산하느냐
			+ 컬렉션 : 모든값을 메모리에 저장 -> 연산을 수행할 떄마다 모든 요소를 메모리에 저장			
			+ 스트림 : 요청할 떄만 요소를 계산 
			==> 구글 검색 처럼
			+ 스트림은 한번만 탑색할 수 있다.
				탐색한 요소를 다시 탐색하려면 새로운 스트림을 만들어야 한다.(중요)
			+ 외부반복(컬렉션)/내부반복(스트림)
				외부반복 : for-each -> 명시적으로 컬렉션의 항목을 하나씩 가져와서 처리
				내부반복 : 반복을 알아서 처리 -> 데이터 표현과 병렬성을 자동으로 구현
				http://palpit.tistory.com/647
	- 스트림 연산 구성
		+ 중간연산(파이프 라인) + 최종연산(파이프라인 close)
		+ 최종연산이 합쳐질 때까지 계산하지 않는다.
			스트림 생성 + 중간연산 + 준간연산 + 중간연산
			------------------------------ X
			스트림 생성 + 중간연산 + 준간연산 + 중간연산 + 최종연산
			----------------------------------> O
			
	그림 추가 p.135
	
	표 추가 p.144
	
Chapter 5. 

- 스트림 활용
	- 필터링/슬라이싱
		- 필더링은 프레디케이트 함수를 인수로받아서 스트림반환 가능
		- .distinct() 가능
		- 스트림 축소
			.limit(n)
		- 요소 건너뛰기
			.skip(n)
	- 매핑
		- 테이블에서 특정 열 데이터 선택가능
		------------------------------------------------------
		List <Integer> di shNameLengths = 
			menu.stream ()
				.map(Dish: :getName)
				.map(String :: length)
				.collect (toList ());
		------------------------------------------------------