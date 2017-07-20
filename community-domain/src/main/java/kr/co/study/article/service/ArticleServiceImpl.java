package kr.co.study.article.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ArticleListDTO;
import kr.co.study.article.repository.ArticleRepository;

public class ArticleServiceImpl implements ArticleService {
	
	ArticleRepository articleRepository;

	@Override
	public void writeNewArticle(ArticleDTO articleDTO) {
		// TODO Auto-generated method stub
		articleRepository.writeNewArticle(articleDTO);
	}

	@Override
	public ModelAndView showArticleList(ArticleDTO articleDTO) {
		// TODO Auto-generated method stub
		ModelAndView view = new ModelAndView();
		
		List<ArticleDTO> articleList = articleRepository.getAllArticleList();
		
		
		ArticleListDTO articleListDTO = new ArticleListDTO();
		articleListDTO.setArticleList(articleList);
		
		view.setViewName("/mainPage");
		view.addObject("articleListDTO", articleListDTO);
		
		
		return view;
	}


}
