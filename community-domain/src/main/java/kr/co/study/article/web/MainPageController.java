package kr.co.study.article.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ArticleListDTO;
import kr.co.study.article.service.ArticleService;

@Controller
public class MainPageController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/mainPage")
	public ModelAndView showArticleList(){
		ModelAndView view = new ModelAndView();
//		ArticleListDTO articleListDTO = new ArticleListDTO();
		//컨트롤러에서 -> 뷰로 던지는 부분은 ModelAndView가 하는 역할이다.
		//서비스에서는 biz에서 하는 부분의 역할. 
		List<ArticleDTO> articleList = new ArrayList<ArticleDTO>(); 
		articleList = articleService.getAllArticleList();
		
		view.addObject("articleList", articleList);
		view.setViewName("article/mainPage");
		return view;
		
	}
	
	
	
	
}
