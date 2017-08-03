package kr.co.study.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/loginPage")
	public String viewLoginPage() {
		return "member/loginPage";
	}
	
	@RequestMapping("/registMemberPage") 
	public String viewRegistMameberPage() {
		return "member/registMemberPage";
	}
	

}
