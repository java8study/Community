package kr.co.study.sample.web;

import kr.co.study.sample.dto.SampleDto;
import kr.co.study.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Controller
@RequestMapping("/mapper/sample")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@RequestMapping("/index.do")
	public List<SampleDto> findAll(){
		return sampleService.findAll();
	}
}
