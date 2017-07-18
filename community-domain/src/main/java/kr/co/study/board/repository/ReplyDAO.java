package kr.co.study.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.board.dto.Reply;


@Mapper
@Repository
public interface ReplyDAO {

  public List<Reply> list(Integer bno) throws Exception;

  public void create(Reply vo) throws Exception;

  public void update(Reply vo) throws Exception;

  public void delete(Integer rno) throws Exception;

  public int count(Integer bno) throws Exception;

  public int getBno(Integer rno) throws Exception;

}
