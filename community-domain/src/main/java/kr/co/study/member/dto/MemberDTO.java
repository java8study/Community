package kr.co.study.member.dto;

import org.apache.ibatis.type.Alias;

@Alias("memberDTO")
public class MemberDTO {

	private int memberId;
	private String userName;
	private String userPassword;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
}
