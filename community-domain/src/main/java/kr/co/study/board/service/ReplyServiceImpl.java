package kr.co.study.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.study.board.dto.Reply;
import kr.co.study.board.repository.BoardDAO;
import kr.co.study.board.repository.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

  @Autowired
  private ReplyDAO replyDAO;
  
  @Autowired 
  private BoardService boardService;
  
  @Transactional
  @Override
  public void addReply(Reply vo) throws Exception {
	
    replyDAO.create(vo);
    boardService.updateReplyCnt(vo.getBno(), 1);
  }
  
  @Transactional
  @Override
  public void removeReply(Integer rno) throws Exception {
  
    int bno = replyDAO.getBno(rno);
    replyDAO.delete(rno);
    boardService.updateReplyCnt(bno, -1);
  }   



  @Override
  public List<Reply> listReply(Integer bno) throws Exception {

    return replyDAO.list(bno);
  }

  @Override
  public void modifyReply(Reply vo) throws Exception {

    replyDAO.update(vo);
  }



  @Override
<<<<<<< HEAD
  public List<Reply> listReplyPage(Integer bno, Criteria cri) 
      throws Exception {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("bno", bno);
	    paramMap.put("cri", cri);	  
    return replyDAO.listPage(paramMap);
  }

  @Override
=======
>>>>>>> jewel1609_2
  public int count(Integer bno) throws Exception {

    return replyDAO.count(bno);
  }

}