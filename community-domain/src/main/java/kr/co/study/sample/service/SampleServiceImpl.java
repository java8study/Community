package kr.co.study.sample.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.study.sample.dto.SampleDto;
import kr.co.study.sample.repository.SampleRepository;

@Service
public class SampleServiceImpl implements SampleService{
	
	@Autowired
	private SampleRepository sampleRepository;

	public List<HashMap<String, Object>> findAll() {
		return sampleRepository.findAll();
	}

	public void joinMember(HashMap<String, Object> params) {
		if (params!=null && params.get("userPwd").equals(params.get("userPwd2"))) {
			sampleRepository.registerMember(params);
		}
	}

	/*public boolean login(String userId, String userPwd) {
		SampleDto result = sampleRepository.findUser(userId);
		if (result == null) {
			System.out.println("SampleService.class : login메서, result==null");
			return false;
		}
		else {
			System.out.println("SampleService.class : login메서, result!=null" + result.toString());
			String pwd = result.getUserPwd();
			if (pwd == null) {
				System.out.println("SampleService.class : login메서, result!=null, pwd==null");
				return false;
			}
			else {
				if (pwd.equals(userPwd)) {
					System.out.println("SampleService.class : login메서, 비번호 맞음" + pwd + "," + userPwd);
					return true;
				}
				else {
					System.out.println("SampleService.class : login메서, 비번호" + pwd + "," + userPwd);
					return false;
				}
			}

		}
	}*/

	public SampleDto login(SampleDto sampleDto) {
		SampleDto result = sampleRepository.findUserIdAndUserPwd(sampleDto);

		if(result == null){
			throw new RuntimeException();
		}

		return result;
	}

	public SampleDto getMemberInfo(String userId) {
		return sampleRepository.findUser(userId);
	}
}
