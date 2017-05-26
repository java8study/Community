package kr.co.study.sample.web;

import kr.co.study.sample.dto.SampleDto;
import kr.co.study.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@RequestMapping("/index.do")
	public String findAll(Model model){
		model.addAttribute("list", sampleService.findAll());
		return "sample/index";
	}
}
