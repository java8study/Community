package kr.co.study.member.service;

import javax.servlet.http.HttpSession;

import kr.co.study.member.dto.MemberDTO;

public interface MemberService {

	String checkLoginMember(MemberDTO memberDTO, HttpSession session);

}
