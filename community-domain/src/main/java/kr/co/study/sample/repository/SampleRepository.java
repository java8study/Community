package kr.co.study.sample.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.sample.dto.SampleDto;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Mapper
@Repository
public interface SampleRepository {
	
	public List<HashMap<String,Object>> findAll();

	public SampleDto findUser(String userId);
	
	public int registerMember(HashMap<String, Object> params);

	public int updateMember(HashMap<String, Object> params);
}
