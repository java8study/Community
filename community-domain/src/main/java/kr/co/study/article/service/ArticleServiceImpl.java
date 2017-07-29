package kr.co.study.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ArticleListDTO;
import kr.co.study.article.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public int writeNewArticle(String title, String contents) {
		// TODO Auto-generated method stub
		return articleRepository.writeNewArticle(title, contents);
	}

	@Override
	public ModelAndView showArticleList(ArticleDTO articleDTO) {
		// TODO Auto-generated method stub
		ModelAndView view = new ModelAndView();
		
//		List<ArticleDTO> articleList = articleRepository.getAllArticleList();
//		
//		
//		ArticleListDTO articleListDTO = new ArticleListDTO();
//		articleListDTO.setArticleList(articleList);
//		
//		view.setViewName("/mainPage");
//		view.addObject("articleListDTO", articleListDTO);
		
		
		return view;
	}

	@Override
	public List<ArticleDTO> getAllArticleList() {
		// TODO Auto-generated method stub
		return articleRepository.getAllArticleList();
	}

	@Override
	public void deleteArticleByArticleId(int articleId) {
		// TODO Auto-generated method stub
		articleRepository.deleteArticleByArticleId(articleId);
	}

	@Override
	public ArticleDTO viewArticleDetailPage(int articleId) {
		// TODO Auto-generated method stub
		return articleRepository.getOneArticleByArticleId(articleId);
	}


}
