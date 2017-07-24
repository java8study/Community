package kr.co.study.board.service;

import java.util.List;

import kr.co.study.board.dto.Reply;

public interface ReplyService {

  public void addReply(Reply vo) throws Exception;

  public List<Reply> listReply(Integer bno) throws Exception;

  public void modifyReply(Reply vo) throws Exception;

  public void removeReply(Integer rno) throws Exception;


  public int count(Integer bno) throws Exception;
}