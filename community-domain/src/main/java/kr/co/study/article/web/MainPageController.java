package kr.co.study.article.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

	@RequestMapping("/mainPage")
	public String mainPage(){
		
		return "article/mainPage";
		
	}
	
	
}
