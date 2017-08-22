package kr.co.study.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.study.member.dto.MemberDTO;
import kr.co.study.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public String checkLoginMember(MemberDTO memberDTO, HttpSession session) {
		// TODO Auto-generated method stub
		int isPossibleLogin = memberRepository.isPossibleLogin(memberDTO);
		
		if ( isPossibleLogin > 0 ) {
			session.setAttribute("_MEMBER_", memberDTO);

			return "SUCCESS";
		}
		else {
			return "FAIL";
		}
	}
	
}
