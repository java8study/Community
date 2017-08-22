package kr.co.study.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.member.dto.MemberDTO;

@Mapper
@Repository
public interface MemberRepository {

	int isPossibleLogin(MemberDTO memberDTO);
	
}
