
package kr.co.study.sample.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

/**
 * Created by coupang on 2017. 5. 26..
 */

@Getter
@Setter
@Alias("sampleDto")
public class SampleDto {

	private long id;
	private String userId;
	private String userPwd;
	private String UserName;
	private String email;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
