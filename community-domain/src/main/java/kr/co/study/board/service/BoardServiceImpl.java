package kr.co.study.board.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.study.board.dto.Board;
import kr.co.study.board.dto.Criteria;
import kr.co.study.board.dto.SearchCriteria;
import kr.co.study.board.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardDAO dao;

  @Override
  public void regist(Board Board) throws Exception {
    dao.create(Board);
  }

//  @Override
//  public Board read(Integer bno) throws Exception {
//    return dao.read(bno);
//  }


  @Transactional(isolation=Isolation.READ_COMMITTED)
  @Override
  public Board read(Integer bno) throws Exception {
    dao.updateViewCnt(bno);
    return dao.read(bno);
  }

  
  @Override
  public void modify(Board Board) throws Exception {
    dao.update(Board);
  }

  @Override
  public void remove(Integer bno) throws Exception {
    dao.delete(bno);
  }

  

  @Override
  public List<Board> listCriteria(Criteria cri) throws Exception {

    return dao.listCriteria(cri);
  }

  @Override
  public int listCountCriteria(Criteria cri) throws Exception {

    return dao.countPaging(cri);
  }

  @Override
  public List<Board> listSearchCriteria(SearchCriteria cri) throws Exception {

    return dao.listSearch(cri);
  }

  @Override
  public int listSearchCount(SearchCriteria cri) throws Exception {

    return dao.listSearchCount(cri);
  }

  public int updateReplyCnt(Integer bno,int amount ) throws Exception {
	  Map<String, Object> paramMap = new HashMap<String, Object>();

	    paramMap.put("bno", bno);
	    paramMap.put("amount", amount);

	  return dao.updateReplyCnt(paramMap);
  }

}
