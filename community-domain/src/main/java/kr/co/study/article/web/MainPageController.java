package kr.co.study.article.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ArticleListDTO;
import kr.co.study.article.dto.ArticleSearchDTO;
import kr.co.study.article.service.ArticleService;
import kr.co.study.article.util.Paging;

@Controller
public class MainPageController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/index.do")
	public String viewIndex() {
		return "article/index";
	}
	
	@RequestMapping("/mainPage")
	public ModelAndView showArticleList(@RequestParam(required=false, defaultValue="0") int pageNo,	@RequestParam(required = false, defaultValue = "") String searchKeyword,
			@RequestParam(required = false, defaultValue = "") String searchType, HttpSession session){
		
		ModelAndView view = new ModelAndView();
		List<ArticleDTO> articleList = new ArrayList<ArticleDTO>(); 
		ArticleListDTO articleListDTO = new ArticleListDTO();
		Paging paging = new Paging();
		
		paging.setPageNumber(pageNo + "");
		
		ArticleSearchDTO searchDTO = new ArticleSearchDTO();
		searchDTO.setStartIndex(paging.getStartArticleNumber());
		searchDTO.setEndIndex(paging.getEndArticleNumber());
		searchDTO.setSearchKeyword(searchKeyword);
		searchDTO.setSearchType(searchType);
		
		session.setAttribute("_SEARCH_ART_", searchDTO);
		
		int totalArticleCount = articleService.getTotalArticleCount(searchDTO);
		paging.setTotalArticleCount(totalArticleCount);
		
		articleList = articleService.getAllArticleList(searchDTO);
		articleListDTO.setArticleList(articleList);
		articleListDTO.setPaging(paging);
		
		
		view.setViewName("article/mainPage");
		view.addObject("articleListDTO", articleListDTO);
		view.addObject("searchDTO", searchDTO);
		
		return view;
	}
	
	@RequestMapping("/articleDetail/{articleId}")
	public ModelAndView viewArticleDetailPage(@PathVariable int articleId ) {
		ModelAndView view = new ModelAndView();
		
		ArticleDTO articleDTO = new ArticleDTO();
		
		articleDTO = articleService.viewArticleDetailPage(articleId);
		
		view.addObject("articleDTO", articleDTO);
		
		view.setViewName("article/articleDetailPage");
		
		return view;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/loginPage";
	}
	
	
	
	
}
