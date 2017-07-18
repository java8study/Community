package kr.co.study.article.service;

import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;

public interface ArticleService {
	
	public void writeNewArticle(ArticleDTO articleDTO);
	
}
