package kr.co.study.article.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ArticleSearchDTO;
import kr.co.study.article.dto.ReplyDTO;

public interface ArticleService {
	
	public void writeNewArticle(ArticleDTO articleDTO);
	
	public ModelAndView showArticleList(ArticleDTO articleDTO);

	public List<ArticleDTO> getAllArticleList(ArticleSearchDTO searchDTO);

	public void deleteArticleByArticleId(int articleId);

	public ArticleDTO viewArticleDetailPage(int articleId);

	public void updateArticleByArticleDTO(ArticleDTO articleDTO);

	public int getTotalArticleCount(ArticleSearchDTO searchDTO);

	public void readsCountUpByArticleId(int articleId);

	public String upLikesCount(ArticleDTO articleDTO);

	public String writeReplyByUserNameAndArticleId(ReplyDTO replyDTO);

	public List<ReplyDTO> viewReplyList(int articleId);

	public void deleteRepliesByArticleId(int articleId);

	public String deleteReplyByReplyId(int replyId);

	
}
