- 스칼라 : 객체지향과 함수형 프로그래밍을 혼합한 언어
- 왜 스칼라인가?
스칼라는 함수형으로 처리하는 개념, 일급함수, 디폴트 메서드 등을 제공.
자바 8에 비해 더 다양하고 심화된 함수형 기능을 제공
자바와 스칼라의 기능비교를 함으로써 함수형 프로그래밍을 확인한다.

기본 문법
java8
```
public class Foo {
    public static void main(String[] args) {
        IntStream .rangeClosed(2 , 6)
        .forEach(n -) System.out.println("Hello " + n + " bottles of beer"));
    }
}
```

scala
```
object Beer {
    def main(args: Array[String]) {
        2 to 6 foreach { n => println(s"Hello ${n} bottles of beer") }
    }
}
```

컬렉션
```
val fileLines = Source.fromFile("data.txt").getLines.toList()
val linesLongUpper = fileLines.filter(l => l.length() > 10).map(l => 1.toUpperCase())
```
```
val linesLongUpper = fileLines filter (_.length() > 10) map(_.toUpperCase())

병렬(par)
val lines LongUpper =
fileLines.par filter (_.length() > 10) map(_.toUpperCase())
```

튜플
```
val book = (2014, "Java 8 in Action ’기 "Manning" )
println(book._1)
```

스트림

java8
```
public String getCarlnsuranceName(Optional<Person> person , int minAge) {
    return person.filter(p -> p.getAge() >= minAge)
        .flatMap(Person: :getCar)
        .flatMap(Car::getlnsurance)
        .map(Insurance: :getName)
        .orElse("Unknown");
}
```

scala
```
def getCarlnsuranceName(person: Option[Person] , minAge: Int)
    person .filter(_.getAge() >= minAge)
    .flatMap(_.getCar)
    .flatMap(_.getlnsurance)
    .map(_.getName)
    .getOrElse("Unknown")
```

일급함수
```
def isJavaMentioned(tweet: String) Boolean = tweet.contains("Java")
val tweets = List(
"1 love the new features in Java 8" ,
"How ’ 5 i t going?" ,
"An SQL query walks into a bar, sees two tables and says ’ Can 1 join you?'"
)
tweets.filter(isJavaMentioned).foreach(println)
```

익명함수
java에서 interface = scala에서 트레이트
java8
```
Function<String , Boolean> i s LongTweet = (String 5) - > s .length() > 60;
boolean l ong = i s LongTweet .appl y( "A very short tweet" );
```
scala
```
val isLongTweet String => Boolean =
    new Function1[String , Boolean] {
        def apply (tweet: String ): Boolean = tweet .length () > 60
}
```

* 클로저 : 함수의 비지역 변수를 자유롭게 참조할 수 있는 함수의 인스턴스를 가리킨다.
- 자바8에서는 변수를 참조는 가능하지만 변경은 불가능하다.
- 스칼라는 변수 참조도 가능하고 변경도 가능하다.
```
def main(args : Array[String]) {
var count 0
val inc () => count+=1
inc()
println(count)
inc()
println(count)
```

클래스
```
class Hello {
    def sayThankYou() {
        println("Thanks for reading our book")
    }
}
val h = new Hello ()
h.sayThankYou()
```

