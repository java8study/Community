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

	// pwd와 pwd2가 일치하면 새로운 회원으로 등록
	public void joinMember(HashMap<String, Object> params) {
		if (params!=null && params.get("userPwd").equals(params.get("userPwd2"))) {
			sampleRepository.registerMember(params);
		}
	}

	public boolean login(String userId, String userPwd) {
		SampleDto result = sampleRepository.findUser(userId);
		if (result == null) {
			System.out.println("SampleService.class : login메서드, result==null");
			return false; // userId가 없는 경우-> 실패
		}
		else { // userId가 있는 경우
			System.out.println("SampleService.class : login메서드, result!=null" + result.toString());
			String pwd = result.getUserPwd();
			if (pwd == null) { // 비밀번호을 입력하지 않은 경우 ->실패
				System.out.println("SampleService.class : login메서드, result!=null, pwd==null");
				return false;
			}
			else { // 비밀번호를 입력한 경우
				if (pwd.equals(userPwd)) { // 비밀번호를 맞게 입력-> 성공
					System.out.println("SampleService.class : login메서드, 비밀번호 맞음" + pwd + "," + userPwd);
					return true;
				}
				else { // 비밀번호를 틀리게 입력-> 실패
					System.out.println("SampleService.class : login메서드, 비밀번호 틀림" + pwd + "," + userPwd);
					return false;
				}
			}

		}
//		return true;
	}

	// 회원 한명의 정보를 가져다줌
	public SampleDto getMemberInfo(String userId) {
		return sampleRepository.findUser(userId);
	}

	//회원 수정
//	 public void memberUpdate(HashMap<String, Object> params){
//		 
//	        if(params.get("userPwd").equals(params.get("userPwd2"))) //비밀번호가 맞다면
//	        {
//	        	SampleDto record = sampleRepository.findUser((String)params.get(SampleDto.userId));
//	            record.putAll(params); //원래있던거에 내가 받은걸로 수정
//	            sampleRepository.updateMember(record);
//	        }
//	    }

}
