package kr.co.study.board.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.study.board.dto.SearchCriteria;

public class testController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody 
	public String listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
			System.out.println("테스트 도착");
			return "성공";
	  }

}
