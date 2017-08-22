package kr.co.study.article.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ArticleListDTO;
import kr.co.study.article.dto.ArticleSearchDTO;
import kr.co.study.article.dto.ReplyDTO;
import kr.co.study.article.dto.ReplyListDTO;
import kr.co.study.article.service.ArticleService;
import kr.co.study.article.util.Paging;
import kr.co.study.member.dto.MemberDTO;

@Controller
public class MainPageController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/index.do")
	public String viewIndex() {
		return "article/index";
	}
	
	@RequestMapping("/mainPage")
	public ModelAndView showArticleList(ArticleSearchDTO searchDTO, HttpSession session, @RequestParam(required = false, defaultValue = "0") int pageNo){
		
		ModelAndView view = new ModelAndView();
		searchDTO.setPageNo(pageNo);
		
		ArticleListDTO articleListDTO = new ArticleListDTO();
		int totalArticleCount = articleService.getTotalArticleCount(searchDTO);
		
		Paging paging = new Paging();
		paging.setTotalArticleCount(totalArticleCount);
		paging.setPageNumber(pageNo + "");
		
		searchDTO.setStartIndex(paging.getStartArticleNumber());
		searchDTO.setEndIndex(paging.getEndArticleNumber());
		
		session.setAttribute("_SEARCH_ART_", searchDTO);
		
		
		List<ArticleDTO> articleList = articleService.getAllArticleList(searchDTO);
		
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
		List<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		ReplyListDTO replyListDTO = new ReplyListDTO();
		
		//조회수 증가
		articleService.readsCountUpByArticleId(articleId);
		
		articleDTO = articleService.viewArticleDetailPage(articleId);
		
		replyList = articleService.viewReplyList(articleId);
		
		replyListDTO.setReplyList(replyList);
		
		view.addObject("articleDTO", articleDTO);
		view.addObject("replyList", replyList);
		
		view.setViewName("article/articleDetailPage");
		
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value = ("/articleDetail/upLikesCount"), method = RequestMethod.POST)
	public HashMap<String, Object> upLikesCount(@RequestParam Map<String,Object> params ) {

		ArticleDTO articleDTO = new ArticleDTO();
		
		articleDTO.setArticleId( Integer.parseInt( (String) params.get("articleId") ) );
		
		
		String likesStatus = articleService.upLikesCount(articleDTO);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
	    hashmap.put( "KEY", likesStatus );
	    
	    return hashmap;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/loginPage";
	}
	
	@RequestMapping("/errorPage")
	public String errorPage() {
		return "member/errorPage";
	}
	
	
	
	
}
