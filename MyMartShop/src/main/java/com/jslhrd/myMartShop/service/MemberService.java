package com.jslhrd.myMartShop.service;

import java.util.List;

import com.jslhrd.myMartShop.domain.MemberDTO;

public interface MemberService {
	//아이디 중복검사
	public int memberIDCheck(String memberid);
	//회원가입 처리
	public int memberInsert(MemberDTO dto);
	//로그인-비밀번호 검색
	public String memberIDPassSearch(MemberDTO dto);
	//로그인-사용자 정보 검색
	public MemberDTO memberLogin(MemberDTO dto);
	//로그인-마지막 접속일자 업데이트
	public void memberLoginUpdate(MemberDTO dto);
	//전체목록
	public List<MemberDTO> memberList();
	//회원삭제
	public int memberDelete(String memberid);
}
