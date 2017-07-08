package kr.co.study.board.repository;

import java.util.List;

import kr.co.study.board.dto.Criteria;
import kr.co.study.board.dto.Reply;



public interface ReplyDAO {

  public List<Reply> list(Integer bno) throws Exception;

  public void create(Reply vo) throws Exception;

  public void update(Reply vo) throws Exception;

  public void delete(Integer rno) throws Exception;

  public List<Reply> listPage(Integer bno, Criteria cri) throws Exception;

  public int count(Integer bno) throws Exception;

  public int getBno(Integer rno) throws Exception;

}
