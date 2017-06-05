package kr.co.study.sample.service;

import kr.co.study.sample.dto.SampleDto;
import kr.co.study.sample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public void insert(){

		SampleDto dto1 = new SampleDto();
		dto1.setName("TEST!");
		sampleRepository.insert(dto1);
		dto1.setName("TEST@");
		sampleRepository.insert(dto1);
	}

}
