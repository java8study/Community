package kr.co.study.article.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("articleListDTO")
public class ArticleListDTO {
	
	private List<ArticleDTO> articleList;

	public List<ArticleDTO> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleDTO> articleList) {
		this.articleList = articleList;
	}
	
	
	
}
