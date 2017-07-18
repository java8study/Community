package kr.co.study.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainArticleController {
	
	@RequestMapping("/home")
	public String mainPage() {
		return "mainPage";
	}

}
