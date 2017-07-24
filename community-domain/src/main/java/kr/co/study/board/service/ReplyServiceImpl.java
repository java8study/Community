package kr.co.study.board.service;

import java.util.List;

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
  private BoardDAO boardDAO;

  @Transactional
  @Override
  public void addReply(Reply vo) throws Exception {

    replyDAO.create(vo);
    boardDAO.updateReplyCnt(vo.getBno(), 1);
  }
  
  @Transactional
  @Override
  public void removeReply(Integer rno) throws Exception {
  
    int bno = replyDAO.getBno(rno);
    replyDAO.delete(rno);
    boardDAO.updateReplyCnt(bno, -1);
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
  public int count(Integer bno) throws Exception {

    return replyDAO.count(bno);
  }

}