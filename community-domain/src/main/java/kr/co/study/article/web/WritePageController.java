package kr.co.study.article.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ReplyDTO;
import kr.co.study.article.service.ArticleService;
import kr.co.study.member.dto.MemberDTO;

@Controller
public class WritePageController {
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/doAdjustWritePage/{articleId}")
	public ModelAndView adjustWritePageView(@PathVariable int articleId) {
		ModelAndView view = new ModelAndView();
		ArticleDTO articleDTO = new ArticleDTO();
		
		articleDTO = articleService.viewArticleDetailPage(articleId);
		
		view.addObject("articleDTO", articleDTO);
		view.setViewName("article/adjustWritePage");
		return view;
	}
	
	@RequestMapping("/doWritePage")
	public ModelAndView viewWritePageView() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("article/writePage");
		return view;
	}
	
	@RequestMapping("/doWriteAction") 
	public String doWriteAction(ArticleDTO articleDTO) {
		
		articleDTO.setUserName("jewel1609");
		
		articleService.writeNewArticle(articleDTO);
		
		return "redirect:/mainPage";
	}
	
	@RequestMapping("/doDeleteAction/{articleId}")
	public String doDeleteAction(@PathVariable int articleId) {
		
		articleService.deleteArticleByArticleId(articleId);
		articleService.deleteRepliesByArticleId(articleId);
		
		return "redirect:/mainPage";
	}
	
	//Update
	@RequestMapping("/doUpdate")
	public String doUpdate(ArticleDTO articleDTO) {
			
		articleService.updateArticleByArticleDTO(articleDTO);
		
		return "redirect:/mainPage";
	}
	
	@ResponseBody
	@RequestMapping(value = ("/articleDetail/writeReplyByUserNameAndArticleId"), method = RequestMethod.POST)
	public HashMap<String, Object> writeReplyByUserNameAndArticleId(@RequestParam Map<String,Object> params, HttpSession session ) {

		System.out.println(params);
		
		ReplyDTO replyDTO = new ReplyDTO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO) session.getAttribute("_MEMBER_");
		
		replyDTO.setArticleId( Integer.parseInt( (String) params.get("articleId") ) );
		replyDTO.setReplyContents( (String) params.get("replyContents") );
		replyDTO.setUserName( memberDTO.getUserName() );
		
		String replyStatus = articleService.writeReplyByUserNameAndArticleId(replyDTO);
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
	    hashmap.put( "KEY", replyStatus );
	    
	    return hashmap;
	}
	
	//댓글 삭제 
	@ResponseBody
	@RequestMapping(value = ("/articleDetail/deleteReplyByReplyId"), method = RequestMethod.POST)
	public HashMap<String, Object> deleteReplyByReplyId(@RequestParam Map<String,Object> params ) {
		
		int replyId = Integer.parseInt((String)params.get("replyId"));
		
		String replyStatus = articleService.deleteReplyByReplyId(replyId);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
	    hashmap.put( "KEY", replyStatus );
	    
	    return hashmap;
	}
	
	//댓글 좋아요 업!
	@ResponseBody
	@RequestMapping(value = ("/articleDetail/replyLikeUpByReplyId"), method = RequestMethod.POST)
	public HashMap<String, Object> replyLikeUpByReplyId(@RequestParam Map<String,Object> params ) {
		
		System.out.println(params);
		
		int replyId = Integer.parseInt((String)params.get("replyId"));
		
		String status = articleService.replyLikeUpByReplyId(replyId);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("KEY", status);
		
		return hashmap;
	}
	
	//댓글 싫어요 업! replyDisLikeUpByReplyId
	@ResponseBody
	@RequestMapping(value = ("/articleDetail/replyDisLikeUpByReplyId"), method = RequestMethod.POST)
	public HashMap<String, Object> replyDisLikeUpByReplyId(@RequestParam Map<String,Object> params ) {
		
		System.out.println(params);
		
		int replyId = Integer.parseInt((String)params.get("replyId"));
		
		String status = articleService.replyDisLikeUpByReplyId(replyId);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("KEY", status);
		
		return hashmap;
	}
	
}
