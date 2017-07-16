package kr.co.study.board.repository;

import java.util.List;

import kr.co.study.board.dto.Board;
import kr.co.study.board.dto.Criteria;
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

  public List<Board> listPage(int page) throws Exception;

  public List<Board> listCriteria(Criteria cri) throws Exception;

  public int countPaging(Criteria cri) throws Exception;
  
  //use for dynamic sql
  
  public List<Board> listSearch(SearchCriteria cri)throws Exception;
  
  public int listSearchCount(SearchCriteria cri)throws Exception;
  
  
  public void updateReplyCnt(Integer bno, int amount)throws Exception;
  
  
  public void updateViewCnt(Integer bno)throws Exception;
  
  public void addAttach(String fullName)throws Exception;
  
  public List<String> getAttach(Integer bno)throws Exception;  
   
  public void deleteAttach(Integer bno)throws Exception;
  
  public void replaceAttach(String fullName, Integer bno)throws Exception;
  
}
