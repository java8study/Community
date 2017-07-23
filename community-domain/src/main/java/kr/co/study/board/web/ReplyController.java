package kr.co.study.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import kr.co.study.board.dto.Reply;
import kr.co.study.board.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

  @Autowired
  private ReplyService service;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<String> register(@RequestBody Reply vo) {
	  
	 System.out.println("댓글 도착");
    ResponseEntity<String> entity = null;
    try {
      service.addReply(vo);
      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }

  @RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
  public ResponseEntity<List<Reply>> list(@PathVariable("bno") Integer bno) {

    ResponseEntity<List<Reply>> entity = null;
    try {
      entity = new ResponseEntity<>(service.listReply(bno), HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    return entity;
  }

  @RequestMapping(value = "/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
  public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody Reply vo) {

    ResponseEntity<String> entity = null;
    try {
      vo.setRno(rno);
      service.modifyReply(vo);

      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }

  @RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
  public ResponseEntity<String> remove(@PathVariable("rno") Integer rno) {

    ResponseEntity<String> entity = null;
    try {
      service.removeReply(rno);
      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }

}
