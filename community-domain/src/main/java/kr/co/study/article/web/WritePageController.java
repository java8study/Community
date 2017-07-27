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
	public String doWriteAction(ArticleDTO articleDTO) {
		articleDTO.setUserName("jewel1609");
		System.out.println(articleDTO.getTitle() + " ------");
		System.out.println(articleDTO.getContents() + " ------");
		articleService.writeNewArticle(articleDTO);
		
		return "redirect:/mainPage";
	}
		
		
	
}
