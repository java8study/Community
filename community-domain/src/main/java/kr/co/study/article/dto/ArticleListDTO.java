package kr.co.study.article.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import kr.co.study.article.util.Paging;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("articleListDTO")
public class ArticleListDTO extends ArticleDTO {
	
	private List<ArticleDTO> articleList;
	
	private Paging paging;

	public List<ArticleDTO> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleDTO> articleList) {
		this.articleList = articleList;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	
	
	
}
