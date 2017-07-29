package kr.co.study.article.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.service.ArticleService;

@Controller
public class WritePageController {
	
	ArticleService articleService;

	@RequestMapping("/doWritePage")
	public String writePageView() {
		return "article/writePage";
	}
	
	@RequestMapping("/doWriteAction") 
	public ModelAndView doWriteAction(String title, String contents) {
		ModelAndView view = new ModelAndView();
		
		ArticleDTO articleDTO = new ArticleDTO();
		
		view.setViewName("redirect:/mainPage");
		//dto로 값넣으면 널포인터 에러가 난다..why..?
//		int checkWriteArticle = articleService.writeNewArticle(title, contents);
		
		return view;
	}
	
	@RequestMapping("/doDeleteAction")
	public String doDeleteAction(ArticleDTO articleDTO) {
		
		int articleId = articleDTO.getArticleId();
		articleService.deleteArticleByArticleId(articleId);
		
		
		return "redirect:/mainPage";
	}
		
		
	
}
