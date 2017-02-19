package kr.co.jr.community.main.controller;

import kr.co.jr.community.main.entity.Test;
import kr.co.jr.community.main.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by LeeJongRyul on 2017-01-29.
 */

@Slf4j
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/index.do")
    public ModelAndView index(ModelAndView mav) {
        System.out.println("------------------------------");
        List<Test> list = mainService.getTestInfo();
        mav.addObject("list", list);
        mav.setViewName("main/index");
        return mav;
    }

    @RequestMapping(value = "/insert.do")
    public void insert() {
        mainService.insertTestInfo();
    }

    @RequestMapping(value = "/getGroupping.do")
    public List<Test> getGroupping(){
        return mainService.getGrouppingTest();
    }

}
