package kr.co.study.board.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PointDAO {

	public void updatePoint(String uid,int point)throws Exception;
	
}

