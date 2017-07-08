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

	// pwd?? pwd2๊ฐ? ?ผ์นํ๋ฉ? ?๋ก์ด ???ผ๋ก? ?ฑ๋ก?
	public void joinMember(HashMap<String, Object> params) {
		if (params!=null && params.get("userPwd").equals(params.get("userPwd2"))) {
			sampleRepository.registerMember(params);
		}
	}

	public boolean login(String userId, String userPwd) {
		SampleDto result = sampleRepository.findUser(userId);
		if (result == null) {
			System.out.println("SampleService.class : login๋ฉ์?, result==null");
			return false; // userId๊ฐ? ?? ๊ฒฝ์ฐ-> ?ค?จ
		}
		else { // userId๊ฐ? ?? ๊ฒฝ์ฐ
			System.out.println("SampleService.class : login๋ฉ์?, result!=null" + result.toString());
			String pwd = result.getUserPwd();
			if (pwd == null) { // ๋น๋?๋ฒํธ? ?? ฅ?์ง? ??? ๊ฒฝ์ฐ ->?ค?จ
				System.out.println("SampleService.class : login๋ฉ์?, result!=null, pwd==null");
				return false;
			}
			else { // ๋น๋?๋ฒํธ๋ฅ? ?? ฅ? ๊ฒฝ์ฐ
				if (pwd.equals(userPwd)) { // ๋น๋?๋ฒํธ๋ฅ? ๋ง๊ฒ ?? ฅ-> ?ฑ๊ณ?
					System.out.println("SampleService.class : login๋ฉ์?, ๋น๋?๋ฒํธ ๋ง์" + pwd + "," + userPwd);
					return true;
				}
				else { // ๋น๋?๋ฒํธ๋ฅ? ??๋ฆฌ๊ฒ ?? ฅ-> ?ค?จ
					System.out.println("SampleService.class : login๋ฉ์?, ๋น๋?๋ฒํธ ??๋ฆ?" + pwd + "," + userPwd);
					return false;
				}
			}

		}
//		return true;
	}

	// ?? ?๋ช์ ? ๋ณด๋?? ๊ฐ?? ธ?ค์ค?
	public SampleDto getMemberInfo(String userId) {
		return sampleRepository.findUser(userId);
	}

	//?? ?? 
//	 public void memberUpdate(HashMap<String, Object> params){
//		 
//	        if(params.get("userPwd").equals(params.get("userPwd2"))) //๋น๋?๋ฒํธ๊ฐ? ๋ง๋ค๋ฉ?
//	        {
//	        	SampleDto record = sampleRepository.findUser((String)params.get(SampleDto.userId));
//	            record.putAll(params); //????๊ฑฐ์ ?ด๊ฐ? ๋ฐ์?๊ฑธ๋ก ?? 
//	            sampleRepository.updateMember(record);
//	        }
//	    }

}
