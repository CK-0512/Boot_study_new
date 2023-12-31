package com.jslhrd.exuser.service;

import java.util.List;

import com.jslhrd.exuser.domain.UserDTO;

public interface UserService {
	//아이디 중복검사
	public int userIDCheck(String userid);
	
	//회원가입처리
	public int userInsert(UserDTO dto);

	//로그인 시 아이디를 이용한 비번 검색
	public String userIdPassSearch(UserDTO dto);
	
	//로그인(ID, PASS) 로그인 성공비 사용자 정보 반환
	public UserDTO userLogin(UserDTO dto);
	
	//로그인 성공시 최근 접속일자 업데이트
	public void userLoginUpdate(UserDTO dto);

	//사용자정보 전체 목록
	public List<UserDTO> userList();

	//회원정보수정처리
	public int userModify(UserDTO dto);

}
