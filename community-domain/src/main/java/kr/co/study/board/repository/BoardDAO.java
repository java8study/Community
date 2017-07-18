package kr.co.study.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.board.dto.Board;
import kr.co.study.board.dto.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {

  public void create(Board vo) throws Exception;

  public Board read(Integer bno) throws Exception;

  public void update(Board vo) throws Exception;

  public void delete(Integer bno) throws Exception;

  public List<Board> listAll() throws Exception;

  public List<Board> listSearch(SearchCriteria cri)throws Exception;
    
  public void updateReplyCnt(Integer bno, int amount)throws Exception;
  
  public void updateViewCnt(Integer bno)throws Exception;
    
}
