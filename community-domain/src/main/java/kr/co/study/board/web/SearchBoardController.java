package kr.co.study.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.study.board.dto.Board;
import kr.co.study.board.dto.PageMaker;
import kr.co.study.board.dto.SearchCriteria;
import kr.co.study.board.service.BoardService;


@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {


	  @Autowired
	  private BoardService service;

	  @RequestMapping(value = "/list", method = RequestMethod.GET)
	  public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {


	    model.addAttribute("list", service.listSearchCriteria(cri));

	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);

	    pageMaker.setTotalCount(service.listSearchCount(cri));

	    model.addAttribute("pageMaker", pageMaker);
	  }

	  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
	  public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
	      throws Exception {

	    model.addAttribute(service.read(bno));
	  }

	  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
	  public String remove(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

	    service.remove(bno);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/sboard/list";
	  }

	  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	  public void modifyPagingGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

	    model.addAttribute(service.read(bno));
	  }

	  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	  public String modifyPagingPOST(Board board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

	    service.modify(board);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");


	    return "redirect:/sboard/list";
	  }

	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public void registGET() throws Exception {

	  }

	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String registPOST(Board board, RedirectAttributes rttr) throws Exception {

	   
	    service.regist(board);

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/sboard/list";
	  }


	}
