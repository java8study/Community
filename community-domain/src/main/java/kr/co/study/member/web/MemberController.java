package kr.co.study.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.study.member.dto.MemberDTO;
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
	
	@ResponseBody
	@RequestMapping(value = ("/checkLoginMember"), method = RequestMethod.POST)
	public HashMap<String, Object> checkLoginMember(@RequestParam Map<String,Object> params, HttpSession session ) {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserName( (String) params.get("userName") );
		memberDTO.setUserPassword( (String) params.get("userPassword") );
		
		
		String loginStatus = memberService.checkLoginMember(memberDTO, session);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
	    hashmap.put( "KEY", loginStatus );
	    
	    return hashmap;
	}
	
	
	

}
