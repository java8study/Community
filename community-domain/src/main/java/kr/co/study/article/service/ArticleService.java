package kr.co.study.article.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;

public interface ArticleService {
	
	public void writeNewArticle(ArticleDTO articleDTO);
	
	public ModelAndView showArticleList(ArticleDTO articleDTO);

	public List<ArticleDTO> getAllArticleList();

	public void deleteArticleByArticleId(int articleId);

	public ArticleDTO viewArticleDetailPage(int articleId);

	
}
