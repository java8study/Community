package kr.co.study.article.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.service.ArticleService;

@Controller
public class MainPageController {

	ArticleService articleService;
	
	@RequestMapping("/mainPage")
	public ModelAndView showArticleList(ArticleDTO articleDTO){
		
		return articleService.showArticleList(articleDTO);
		//컨트롤러에서 -> 뷰로 던지는 부분은 ModelAndView가 하는 역할이다.
		//서비스에서는 biz에서 하는 부분의 역할. 
		
	}
	
	
	
	
}
