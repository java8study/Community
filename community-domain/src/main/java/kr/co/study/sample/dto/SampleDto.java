package kr.co.study.sample.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by coupang on 2017. 5. 26..
 */

@Getter
@Setter
public class SampleDto {
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
