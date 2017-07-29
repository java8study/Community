package kr.co.study.board.service;

import java.util.List;

import kr.co.study.board.dto.Board;
import kr.co.study.board.dto.Criteria;
import kr.co.study.board.dto.SearchCriteria;



public interface BoardService {

	public void regist(Board board) throws Exception;

	  public Board read(Integer bno) throws Exception;

	  public void modify(Board board) throws Exception;

	  public void remove(Integer bno) throws Exception;

	  public List<Board> listCriteria(Criteria cri) throws Exception;

	  public int listCountCriteria(Criteria cri) throws Exception;

	  public List<Board> listSearchCriteria(SearchCriteria cri) 
	      throws Exception;

	  public int listSearchCount(SearchCriteria cri) throws Exception;

	  public int  updateReplyCnt(Integer bno,int amount ) throws Exception;
}
