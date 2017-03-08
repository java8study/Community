#Chapter1
1. 자바를 눈여겨 봐야 하는 이유
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

 자바8에서 새로 생긴 기능

 * 메서드에 코드를 전달하는 기법 (동작 파라미터화)
 * 함수형 프로그램 (Optional<T>)
 * 람다 ( 익명함수 )
 * 스트림
 * 디폴트 메서드