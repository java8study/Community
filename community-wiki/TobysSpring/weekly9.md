2. 리턴타입의 종류
```
public void add(@ModelAttribute("user") User user) 
public void (@ModelAttribute User user)
public void add(User user)

user라는 이름으로 User오브젝트 return
```

- Map, ModelMap, Model 파라미터
- @ModelAttribute 메소드
```
@ModelAttribute("codes")
public List<Code> codes() {
    return codeService.getAllCodes();
}
```

- BindingResult, ModelAndView, String, void
 
```
public void hello(@RequestParam String name, Model model)
```

- View
- @ResponseBody
    - String 타입을 지원하는 메세지 컨버터가 이를 변환해서 HttpServletResponse의 출력 스트림에 넣어버린다.
- @SessionAttributes 
    - Session에 정보 저장
- SessionStatus
    - 현재 컨트롤러에 의해 세션에 저장된 정보를 모두 제거해준다.

모델 바인딩과 검증
1. PropertyEditor
    - 디폴트 프로퍼티 에디터
```
@RequestMapping("/hello")
public void hello(@RequestParam Charset charset, Model model){}
```

- 커스텀 프로퍼티 에디터
	- 스프링이 디폴트로 등록해서 적용해주는 프로퍼티 에디터는 자바의 기본적인 타입 20여가지에 불과하다.
	- 직접 정의한 타입으로 직접 바인딩을 하고 싶다면, 프로퍼티 에디터를 직접 작성하면된다.
	- PropertyEditorSupport 재구현
	- getAsTest(), setAsText(String text) Override
- @InitBinder
	- 직접 정의한 커스텀 프로퍼티 에디터를 자동으로 바인딩 시키기 위해서는 Custom WebDataBinder를 등록시켜야 한다.
```
@InitBinder
public void initBinder(WebDataBinder dataBinder){
    dataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
}
```
- @InitBinder가 붙은 initBinder() 메소드는 메소드 파리미터를 바인딩하기 전에 자동으로 호출된다.
- WebDataBinder의 바인딩 적용 대상은 @RequestParam, @CookieValue, @RequestHeader, @PathVariable, @ModelAttribute
- @InitBinder 매소드는 싱글턴이 될 수 없다.



