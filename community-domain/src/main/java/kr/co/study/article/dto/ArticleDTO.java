package kr.co.study.article.dto;

import org.apache.ibatis.type.Alias;

@Alias("articleDTO")
public class ArticleDTO {
	
	private int articleId;
	
	private String userName;
	private String title;
	private String contents;
	
	private int likesCount;
	private int readsCount;
	
	private String writeDate;
	
	
	//getter,setter
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	public int getReadsCount() {
		return readsCount;
	}
	public void setReadsCount(int readsCount) {
		this.readsCount = readsCount;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	

}