package kr.co.study.article.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("replyListDTO")
public class ReplyListDTO extends ReplyDTO {
	
	private List<ReplyDTO> replyList;

	public List<ReplyDTO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyDTO> replyList) {
		this.replyList = replyList;
	}
	
	

}
