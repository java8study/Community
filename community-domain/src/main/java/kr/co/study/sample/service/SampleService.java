package kr.co.study.sample.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.study.sample.dto.SampleDto;
import kr.co.study.sample.repository.SampleRepository;

/**
 * Created by coupang on 2017. 5. 26..
 */
@Service
public class SampleService {

	@Autowired
	private SampleRepository sampleRepository;

	public List<HashMap<String, Object>> findAll() {
		return sampleRepository.findAll();
	}

	// pwd?? pwd2ê°? ?¼ì¹˜í•˜ë©? ?ƒˆë¡œìš´ ?šŒ?›?œ¼ë¡? ?“±ë¡?
	public void joinMember(HashMap<String, Object> params) {
		if (params!=null && params.get("userPwd").equals(params.get("userPwd2"))) {
			sampleRepository.registerMember(params);
		}
	}

	public boolean login(String userId, String userPwd) {
		SampleDto result = sampleRepository.findUser(userId);
		if (result == null) {
			System.out.println("SampleService.class : loginë©”ì„œ?“œ, result==null");
			return false; // userIdê°? ?—†?Š” ê²½ìš°-> ?‹¤?Œ¨
		}
		else { // userIdê°? ?ˆ?Š” ê²½ìš°
			System.out.println("SampleService.class : loginë©”ì„œ?“œ, result!=null" + result.toString());
			String pwd = result.getUserPwd();
			if (pwd == null) { // ë¹„ë?ë²ˆí˜¸?„ ?…? ¥?•˜ì§? ?•Š?? ê²½ìš° ->?‹¤?Œ¨
				System.out.println("SampleService.class : loginë©”ì„œ?“œ, result!=null, pwd==null");
				return false;
			}
			else { // ë¹„ë?ë²ˆí˜¸ë¥? ?…? ¥?•œ ê²½ìš°
				if (pwd.equals(userPwd)) { // ë¹„ë?ë²ˆí˜¸ë¥? ë§ê²Œ ?…? ¥-> ?„±ê³?
					System.out.println("SampleService.class : loginë©”ì„œ?“œ, ë¹„ë?ë²ˆí˜¸ ë§ìŒ" + pwd + "," + userPwd);
					return true;
				}
				else { // ë¹„ë?ë²ˆí˜¸ë¥? ??ë¦¬ê²Œ ?…? ¥-> ?‹¤?Œ¨
					System.out.println("SampleService.class : loginë©”ì„œ?“œ, ë¹„ë?ë²ˆí˜¸ ??ë¦?" + pwd + "," + userPwd);
					return false;
				}
			}

		}
//		return true;
	}

	// ?šŒ?› ?•œëª…ì˜ ? •ë³´ë?? ê°?? ¸?‹¤ì¤?
	public SampleDto getMemberInfo(String userId) {
		return sampleRepository.findUser(userId);
	}

	//?šŒ?› ?ˆ˜? •
//	 public void memberUpdate(HashMap<String, Object> params){
//		 
//	        if(params.get("userPwd").equals(params.get("userPwd2"))) //ë¹„ë?ë²ˆí˜¸ê°? ë§ë‹¤ë©?
//	        {
//	        	SampleDto record = sampleRepository.findUser((String)params.get(SampleDto.userId));
//	            record.putAll(params); //?›?˜?ˆ?˜ê±°ì— ?‚´ê°? ë°›ì?ê±¸ë¡œ ?ˆ˜? •
//	            sampleRepository.updateMember(record);
//	        }
//	    }

}
