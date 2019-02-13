package kr.co.study.sample.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Slf4j
@Controller
public class SampleController {

    // Login Page
    @RequestMapping("loginForm.do")
    public String loginForm() {
        return "loginForm";
    }


    @RequestMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm.do";

    }
}
