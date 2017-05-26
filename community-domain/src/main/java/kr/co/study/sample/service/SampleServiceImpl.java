package kr.co.study.sample.service;

import kr.co.study.sample.dto.SampleDto;
import kr.co.study.sample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Service
public class SampleServiceImpl implements SampleService{

	@Autowired
	private SampleRepository sampleRepository;
	@Override
	public List<SampleDto> findAll() {
		return sampleRepository.findAll();
	}
}
