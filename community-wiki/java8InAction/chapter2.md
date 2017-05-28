동작 파라미터화 코드 전달하기
- 동작 파라미터화
    - 동작을 파라미터로 전달 하는 방법
```
public class AppleRedAndHeaveyPredicate implements ApplePredicate{
 public boolean test(Apple apple){
 return "red".equals(apple.getColor()) && apple.getWeight() > 150;
 }
}
```
- 익명 클래스
    - 동작 파라미터화를 익명 클래스로 대체할 수 있다.
```
List<Apple> redApples = filterApples(inventory, new ApplePredicate(){
 public boolean test(Apple apple){
 return "red".equals(apple.getColor());
 }
});
```
- 람다 표현식
    - 동작 파라미터화, 익명클래스를 람다 표현식으로 대체할 수 있다.
```
List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
```
