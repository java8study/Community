package kr.co.study.article.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.article.dto.ArticleDTO;

@Mapper
@Repository
public interface ArticleRepository {

	void writeNewArticle(ArticleDTO articleDTO);
	
}
