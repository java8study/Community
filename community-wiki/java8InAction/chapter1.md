1. 자바를 눈여겨 봐야 하는 이유
- 자바가 거듭 변화하는 이유

- 컴퓨팅 환경의 변화 : 멀티코어와 대용량 데이터 집합(빅데이터) 처리

- 시대적 변화 요구 : 기존의 명령형을 탈피한 함수형 스타일의 새로운 아키텍처

- 자바8의 새로운 기능 소개
    * 메서드에 코드를 전달하는 기법 (동작 파라미터화)
    * 함수형 프로그램 (Optional<T>)
    * 람다 ( 익명함수 )
    * 스트림
    * 디폴트 메서드
 
- 자바8의 특징
```
Collections.sort(inventory, new Comparator<Apple>() {
  public int compare(Apple a1, Apple a2){
    return a1.getWeight().compareTo(a2.getWeight());
  }
});
```

```
  inventory.sort(comparing(Apple::getWeight));
```

 * 코드가 짧아진다.
 * 병렬 실행이 새롭고 단순한 방식으로 제공된다.

 
