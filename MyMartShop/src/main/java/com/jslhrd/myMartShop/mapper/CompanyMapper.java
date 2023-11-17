package com.jslhrd.myMartShop.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jslhrd.myMartShop.domain.CompanyDTO;

@Mapper
public interface CompanyMapper {
	// 아이디 중복검사
	public int companyIDCheck(String c_name);

	// 회원가입 처리
	public int companyInsert(CompanyDTO dto);

	// 로그인-비밀번호 검색
	public String companyIDPassSearch(CompanyDTO dto);

	// 로그인-사용자 정보 검색
	public CompanyDTO companyLogin(CompanyDTO dto);

}
