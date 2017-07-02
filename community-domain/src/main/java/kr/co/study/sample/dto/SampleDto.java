package kr.co.study.sample.dto;

/**
 * Created by coupang on 2017. 5. 26..
 */

public class SampleDto {
	
	private long id;
	private String userId;
	private String userPwd;
	private String UserName;
	private String email;
	
	public SampleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SampleDto [id=" + id + ", userId=" + userId + ", userPwd=" + userPwd + ", UserName=" + UserName
				+ ", email=" + email + "]";
	}
	
}
