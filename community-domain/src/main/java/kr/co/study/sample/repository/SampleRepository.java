package kr.co.study.sample.repository;

import kr.co.study.sample.dto.SampleDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Mapper
@Repository
public interface SampleRepository {
	List<SampleDto> findAll();
}
