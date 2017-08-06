
package kr.co.study.sample.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.study.sample.dto.SampleDto;
import kr.co.study.sample.service.SampleService;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Slf4j
@Controller
public class SampleController {

	@Autowired
	private SampleService sampleService;

	// Login Page
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "loginForm";
	}

	// Register Page
	@RequestMapping("registerForm.do")
	public void registerForm() {
	}

	@RequestMapping("register.do")
	public String join(@RequestParam HashMap<String, Object> params) {
		
		sampleService.joinMember(params);
		return "redirect:loginForm.do";
	}
	

	 /*@RequestMapping("login.do")
		public ModelAndView login(HttpSession session,String userId, String userPwd){
	        ModelAndView mav = new ModelAndView();
	        if(sampleService.login(userId, userPwd)){
	        	  log.debug("SampleController.class : login메서드 , sample.login(" + userId + "," + userPwd + ") == true");
	        	  SampleDto user = sampleService.getMemberInfo(userId);
	              session.setAttribute("user", user);
	            mav.setViewName("redirect:loginSuccess.do");
	        }
	        else{
	            //return "redirect:loginForm.do";
	        	 System.out.println("SampleController.class : login메서드 , sample.login(" + userId + "," + userPwd + ") == false");
	            mav.setViewName("redirect:loginForm.do");
	        }
	        return mav;
	    }*/

	@RequestMapping("login.do")
	public String login(SampleDto sampleDto, HttpSession session) {
		try {
			SampleDto dto = sampleService.login(sampleDto);
			session.setAttribute("user", dto);
			return "redirect:loginSuccess.do";
		} catch (RuntimeException e) {
			return "redirect:loginForm.do";
		}

	}

	@RequestMapping("loginSuccess.do")
	public String main(Model model, HttpSession session) {
		SampleDto user = (SampleDto) session.getAttribute("user");
		if (user == null)
			return "redirect:loginForm.do";
		else {
			model.addAttribute("userId", user.getId());
			model.addAttribute("userName", user.getUserName());
			model.addAttribute("email", user.getEmail());
			return "loginSuccess";
		}
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm.do";

	}
}
