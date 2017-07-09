package kr.co.study.board.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.study.board.dto.Criteria;
import kr.co.study.board.dto.Reply;


@Repository
public class ReplyDAOImpl implements ReplyDAO {

  @Autowired
  private SqlSession session;

  private static String namespace = "kr.co.study.board.mapper.ReplyMapper";

  @Override
  public List<Reply> list(Integer bno) throws Exception {

    return session.selectList(namespace + ".list", bno);
  }

  @Override
  public void create(Reply vo) throws Exception {

    session.insert(namespace + ".create", vo);
  }

  @Override
  public void update(Reply vo) throws Exception {

    session.update(namespace + ".update", vo);
  }

  @Override
  public void delete(Integer rno) throws Exception {

    session.update(namespace + ".delete", rno);
  }

  @Override
  public List<Reply> listPage(Integer bno, Criteria cri) throws Exception {

    Map<String, Object> paramMap = new HashMap<>();

    paramMap.put("bno", bno);
    paramMap.put("cri", cri);

    return session.selectList(namespace + ".listPage", paramMap);
  }

  @Override
  public int count(Integer bno) throws Exception {

    return session.selectOne(namespace + ".count", bno);

  }

  @Override
  public int getBno(Integer rno) throws Exception {

    return session.selectOne(namespace + ".getBno", rno);
  }
  
  
}
