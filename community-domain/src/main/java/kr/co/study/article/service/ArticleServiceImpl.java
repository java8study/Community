package kr.co.study.article.service;

import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.repository.ArticleRepository;

public class ArticleServiceImpl implements ArticleService {
	
	ArticleRepository articleRepository;

	@Override
	public void writeNewArticle(ArticleDTO articleDTO) {
		// TODO Auto-generated method stub
		articleRepository.writeNewArticle(articleDTO);
	}


}
