package kr.co.study.article.dto;

import org.apache.ibatis.type.Alias;

import kr.co.study.member.dto.MemberDTO;

@Alias("replyDTO")
public class ReplyDTO {

	private int replyId;
	private int articleId;
	private int replyLikesCount;
	private int replyDisLikesCount;
	
	private String replyContents;
	private String replyWriteDate;
	private String userName;

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getReplyLikesCount() {
		return replyLikesCount;
	}

	public void setReplyLikesCount(int replyLikesCount) {
		this.replyLikesCount = replyLikesCount;
	}

	public int getReplyDisLikesCount() {
		return replyDisLikesCount;
	}

	public void setReplyDisLikesCount(int replyDisLikesCount) {
		this.replyDisLikesCount = replyDisLikesCount;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	public String getReplyWriteDate() {
		return replyWriteDate;
	}

	public void setReplyWriteDate(String replyWriteDate) {
		this.replyWriteDate = replyWriteDate;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	
}
