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

	// pwd?? pwd2�? ?��치하�? ?��로운 ?��?��?���? ?���?
	public void joinMember(HashMap<String, Object> params) {
		if (params!=null && params.get("userPwd").equals(params.get("userPwd2"))) {
			sampleRepository.registerMember(params);
		}
	}

	public boolean login(String userId, String userPwd) {
		SampleDto result = sampleRepository.findUser(userId);
		if (result == null) {
			System.out.println("SampleService.class : login메서?��, result==null");
			return false; // userId�? ?��?�� 경우-> ?��?��
		}
		else { // userId�? ?��?�� 경우
			System.out.println("SampleService.class : login메서?��, result!=null" + result.toString());
			String pwd = result.getUserPwd();
			if (pwd == null) { // 비�?번호?�� ?��?��?���? ?��?? 경우 ->?��?��
				System.out.println("SampleService.class : login메서?��, result!=null, pwd==null");
				return false;
			}
			else { // 비�?번호�? ?��?��?�� 경우
				if (pwd.equals(userPwd)) { // 비�?번호�? 맞게 ?��?��-> ?���?
					System.out.println("SampleService.class : login메서?��, 비�?번호 맞음" + pwd + "," + userPwd);
					return true;
				}
				else { // 비�?번호�? ??리게 ?��?��-> ?��?��
					System.out.println("SampleService.class : login메서?��, 비�?번호 ??�?" + pwd + "," + userPwd);
					return false;
				}
			}

		}
//		return true;
	}

	// ?��?�� ?��명의 ?��보�?? �??��?���?
	public SampleDto getMemberInfo(String userId) {
		return sampleRepository.findUser(userId);
	}

	//?��?�� ?��?��
//	 public void memberUpdate(HashMap<String, Object> params){
//		 
//	        if(params.get("userPwd").equals(params.get("userPwd2"))) //비�?번호�? 맞다�?
//	        {
//	        	SampleDto record = sampleRepository.findUser((String)params.get(SampleDto.userId));
//	            record.putAll(params); //?��?��?��?��거에 ?���? 받�?걸로 ?��?��
//	            sampleRepository.updateMember(record);
//	        }
//	    }

}
