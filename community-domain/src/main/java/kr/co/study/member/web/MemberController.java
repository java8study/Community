package kr.co.study.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.study.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/loginPage")
	public String viewLoginPage() {
		return "member/loginPage";
	}
	
	@RequestMapping("/registMemberPage") 
	public String viewRegistMameberPage() {
		return "member/registMemberPage";
	}
	

}
