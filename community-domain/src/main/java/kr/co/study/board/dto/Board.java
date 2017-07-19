package kr.co.study.board.dto;

import org.apache.ibatis.type.Alias;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Board {

  private Integer bno;
  private String title;
  private String content;
  private String writer;
  private Date regdate;
  private int viewcnt;
  private int replycnt;

  
  public Board(){}
  public Integer getBno() {
	return bno;
}
  

  

public void setBno(Integer bno) {
	this.bno = bno;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public Date getRegdate() {
	return regdate;
}

public void setRegdate(Date regdate) {
	this.regdate = regdate;
}

public int getViewcnt() {
	return viewcnt;
}

public void setViewcnt(int viewcnt) {
	this.viewcnt = viewcnt;
}

public int getReplycnt() {
	return replycnt;
}

public void setReplycnt(int replycnt) {
	this.replycnt = replycnt;
}

@Override
  public String toString() {
    return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
        + regdate + ", viewcnt=" + viewcnt + ", replycnt=" + replycnt + "]";
  }

}
