
package kr.co.study.sample.service;

import java.util.HashMap;
import java.util.List;
import kr.co.study.sample.dto.SampleDto;


public interface SampleService {

	public List<HashMap<String, Object>> findAll();

	public void joinMember(HashMap<String, Object> params);

	public SampleDto login(SampleDto sampleDto);

	public SampleDto getMemberInfo(String userId);
}
