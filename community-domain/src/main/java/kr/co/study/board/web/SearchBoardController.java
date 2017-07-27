package kr.co.study.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.study.board.dto.Board;
import kr.co.study.board.dto.SearchCriteria;
import kr.co.study.board.service.BoardService;


@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

  @Autowired
  private BoardService service;

  @RequestMapping(value = "/list", method = RequestMethod.GET) //@ModelAttribute("cri") SearchCriteria cri 이거로 추가해도 됨
  public void listPage(SearchCriteria searchCriteria,Model model) throws Exception {
	  
	  model.addAttribute("cri",searchCriteria);
	  model.addAttribute("list", service.listSearchCriteria(searchCriteria)); 
  }

//  @RequestMapping(value = "/readPage/{bno}", method = RequestMethod.GET)
//  public ModelAndView read(@PathVariable("bno") int bno)
//      throws Exception {
//	  ModelAndView model = new ModelAndView("sboard/readPage");
//    model.addObject(service.read(bno));
//    return model;
//  }
  @RequestMapping(value="/readPage/{bno}", method=RequestMethod.GET)
  public String read(@PathVariable("bno") int bno, Model model) throws Exception{
	  model.addAttribute("board", service.read(bno));
	  return "sboard/readPage";
  }

  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
  public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

    service.remove(bno);

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:/sboard/list";
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
  public void modifyPagingGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

    model.addAttribute(service.read(bno));
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
  public String modifyPagingPOST(Board board, RedirectAttributes rttr) throws Exception {


    service.modify(board);
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
  
  
 /* @RequestMapping(value = "/serchList",method = RequestMethod.POST)
  public ModelAndView serchList(SearchCriteria searchCriteria) throws Exception{
	  logger.info(searchCriteria.toString());
	  ModelAndView model = new ModelAndView("sboard/list");
	  model.addObject(service.listSearchCriteria(searchCriteria));
	  return model;
  }*/
}
