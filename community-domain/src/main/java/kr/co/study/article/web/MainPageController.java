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
		
	}
	
	
	
}
