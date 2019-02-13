package kr.co.study.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by coupang on 2017. 5. 26..
 */
@RestController
public class SampleController {

    // Login Page
    @GetMapping("loginForm.do")
    public String loginForm() {
        return "loginForm";
    }


    @GetMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm.do";

    }
}
