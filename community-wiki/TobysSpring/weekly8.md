스프링 @MVC

1. @ReqeustMapping 핸들러 매핑
```
@RequestMapping(value="/user/add")  // /user/add
@RequestMapping(value="/user/add",method=RequestMethod.GET)  //  /user/add
@RequestMapping(value="/user/edit", params="types=admin")  //  /user/add?types=amdin
@RequestMapping(value="/view", headers="content-type=text/*") // /view
```
```
@RequestMapping("/user") 
public class UserController (
    @RequestMapping("/add") public String add(. . . ) { }  //  /user/add
}
```

```
@RequestMapping("/user") 
public class Super { }
public class Sub extends Super {
    @RequestMapping("/add") 
    public String add() { ... }  //  /user/add
// interface도 동일
```

```
public class Super {
    @RequestMapping("/list") 
    public String list() { ... } // /user/list
}
@RequestMapping("/user") 
public class Sub extends Super { }

// 오버라이드
@ReQuestMapping("/user") 
public class Sub extends Super { 
public String list() { ... }  //  /user/list
}
```

```
@RequestMapping("/usr") 
public class Super { 
    @RequestMapping(value="/catalog", method=RequestMethod.POST) 
    public String list() { ... }
}

@RequestMapping("/user“) 
public class Sub extends Super { 
    @RequestMapping("list") 
    public String list() { ... } // method=RequestMethod.POST는 상속이 안됨.
}
```

```
public class Sub { 
    @RequestMapping
    public String list() { ... } //  /user/list
}
```
```
public abstract class GenericController<T, K, S>
S service;
@RequestMapping("/add") public void add(T entity) { seervice.add(T) } 
@RequestMapping("/update") public void update(T entity) { service.update(T)} 
ORequestMapping("/view") public T view(P id) { service.view(P) } 
ORequestMapping("/delete") public void delete(P id) { service.delete(P) } 
ORequestMapping("list") public List<T> list() { service.list() }
}
```

@Controller
메소드 파라미터의 종류
HttpServletRequest, HttpServletResponse
HttpSession
WebRequest, NativeWebRequest
Locale
InputStream, Reader
OutputStream, Writer
@PathVariable
```
@RequestMapping( "/user/view/{id}")
public String view(@PathVariable("id") int id) {}
```
@RequestParam
```
public String view(@RequestParam("id") int id)
```

@CookieValue
```
public String check(@CookieValue(value="auth", required=false, defaultValue="NONE" String auth) { ... }
```

@RequestHeader
```
public void header(@RequestHeader("Host') String host, @RequestHeader("Keep-Alive") long keepAlive)
```

Map, Model, ModelMap

@ModelAttribute
- 메소드 파라미터에도 부여할 수 있고, 메소드 레벨에 적용할 수 있다.
- @ModelAttribute는 별도의 설정 없이도 자동으로 뷰에 전달된다.
- 생략가능
- 요청 파라미터를 @ModelAttribute가 붙은 파라미터 타입의 오브젝트를 만ㄷ르고 프로퍼티를 통해 요청 파라미터를 넣어준다ㅏ.
- validation 체크 (type Error 등등)

Errors, BindingResult
- @ModelAttribute에서 진행한 validation의 결과 값을 가지고 있다.

SessionStatus
- 컨트롤러가 제공하는 기능 중 모델 오브젝트를 세션에 저장했다가 다음 페이지에서 다시 활용하게 해주는 기능.
@RequestBody
```
public void message(@RequstBody String body) { ..
```

@Value
```
public String hello(@Value('’#(systemProperties['os.name')}") String osName) { ... }
```

```
public class HelloController {
@Value("#{systemProperties['os.name')}") String osName;
```

@Valid
 - JSR-303의 빈 검증기를 이용해서 모델 오브젝트를 검증하도록 지시하는 지시자
 - 뒤에 다시 나옴
