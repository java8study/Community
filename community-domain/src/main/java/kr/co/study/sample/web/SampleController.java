package kr.co.study.sample.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
    public String join(@RequestParam HashMap<String, Object> params)
    {
        System.out.println(params);
        sampleService.joinMember(params);
        return "redirect:loginForm.do"; 
    }
	
//	@RequestMapping("login.do")
//  public ModelAndView login(HttpSession session, String id, String pwd){
////  ?Ñ±Í≥? ?ã§?å®?óê ?î∞?ùº Î¶¨Îã§?ù¥?†â?ä∏ Î∞©Ìñ• Í≤∞Ï†ï
//      //session?Ç¨?ö©?? Îß§Í∞úÎ≥??àò?óê sessionÏ∞∏Ï°∞Î≥??àòÎ•? ?ëêÎ©? ?ûê?èô?úºÎ°? ?ì§?ñ¥?òµ?ãà?ã§ 
//      //login.doÏ≤òÎ¶¨Î•? ?ôÑ?Ñ±?ïò?Ñ∏?öî 
//      //Î°úÍ∑∏?ù∏ ?Ñ±Í≥µÏù¥Î©? main.do Î¶¨Îã§?ù¥?†â?ä∏
////      //Î°úÍ∑∏?ù∏ ?ã§?å®?ù¥Î©? loginForm.do Î¶¨Îã§?ù¥?†â?ä∏
//		
//      if(sampleService.login(id, pwd)){
//    	  System.out.println("SampleController.class : loginÎ©îÏÑú?ìú , sample.login(" + id + "," + pwd + ") == true");
//    	  SampleDto user = sampleService.getMemberInfo(id);
//          session.setAttribute("user", user);
//          return "redirect:loginSuccess.do";
//      }
//      else{
//    	  System.out.println("SampleController.class : loginÎ©îÏÑú?ìú , sample.login(" + id + "," + pwd + ") == false");
//          return "redirect:loginForm.do";
//      }
//  
//  }
	
	 @RequestMapping("login.do")
	    public ModelAndView login(HttpSession session,String userId, String userPwd){
//	    ?Ñ±Í≥? ?ã§?å®?óê ?î∞?ùº Î¶¨Îã§?ù¥?†â?ä∏ Î∞©Ìñ• Í≤∞Ï†ï
	        //session?Ç¨?ö©?? Îß§Í∞úÎ≥??àò?óê sessionÏ∞∏Ï°∞Î≥??àòÎ•? ?ëêÎ©? ?ûê?èô?úºÎ°? ?ì§?ñ¥?òµ?ãà?ã§ 
	        //login.doÏ≤òÎ¶¨Î•? ?ôÑ?Ñ±?ïò?Ñ∏?öî 
	        //Î°úÍ∑∏?ù∏ ?Ñ±Í≥µÏù¥Î©? index.do Î¶¨Îã§?ù¥?†â?ä∏
//	        //Î°úÍ∑∏?ù∏ ?ã§?å®?ù¥Î©? loginForm.do Î¶¨Îã§?ù¥?†â?ä∏
	        ModelAndView mav = new ModelAndView();
	        if(sampleService.login(userId, userPwd)){
	        	  System.out.println("SampleController.class : loginÎ©îÏÑú?ìú , sample.login(" + userId + "," + userPwd + ") == true");
	        	  SampleDto user = sampleService.getMemberInfo(userId);
	              session.setAttribute("user", user);
	            mav.setViewName("redirect:loginSuccess.do");
	        }
	        else{
	            //return "redirect:loginForm.do";
	        	 System.out.println("SampleController.class : loginÎ©îÏÑú?ìú , sample.login(" + userId + "," + userPwd + ") == false");
	            mav.setViewName("redirect:loginForm.do");
	        }
	        return mav;
	    }    
	 
	 @RequestMapping("loginSuccess.do")
	    public String main(Model model,HttpSession session ){
	        SampleDto user = (SampleDto)session.getAttribute("user");
	        if(user == null)
	            return "redirect:loginForm.do";
	        else{
//	            model.addAllAttributes(service.getMemberInfo(id))<= Map?ùÑ ?ÜµÏ±ÑÎ°ú ?ã£Í∏? 
//	            model.addAttibute(arg0); <= Î™®Îç∏ Í∞ùÏ≤¥Î•? ?ÜµÏ±ÑÎ°ú ?ã£Í∏? 
//	            model.addAttribute(arg0, arg1); <=?Ç§ Í∞? Ïß??†ï ?ïò?Çò?ùò ?ç∞?ù¥?Ñ∞ ?ã£Í∏? 
//	            model.addAllAttributes(sampleService.getMemberInfo(userId));
	        	model.addAttribute("userId", user.getId());
	        	model.addAttribute("userName", user.getUserName());
	        	model.addAttribute("email", user.getEmail());
	            return "loginSuccess";
	        }       
	    }
	 
	 @RequestMapping("logout.do")
	    public String logout(HttpSession session){
//	        session.invalidate();
	        session.removeAttribute("userId");
	        return "redirect:loginForm.do";
	        
	    }
	 
//	 @RequestMapping("memberUpdateForm.do")
//	    public String memberUpdateForm(Model model,HttpSession session){
//	        String userId = (String) session.getAttribute("userId");
//	        if(userId == null)
//	            return "redirect:loginForm.do";
//	        model.addAllAttributes(sampleService.getMemberInfo(userId));
//	        return "memberUpdateForm";
//	    }
//	 
//	 @RequestMapping("memberUpdate.do")
//	    public String memberUpdate(@RequestParam HashMap<String, Object> params){
//		 sampleService.memberUpdate(params);
//	        return "redirect:loginSuccess.do";
//	    }

}
