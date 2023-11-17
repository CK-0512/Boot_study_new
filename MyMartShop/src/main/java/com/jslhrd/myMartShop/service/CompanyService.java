package com.jslhrd.myMartShop.service;

import com.jslhrd.myMartShop.domain.CompanyDTO;

public interface CompanyService {
	// 아이디 중복검사
	public int companyIDCheck(String c_name);

	// 로그인-비밀번호 검색
	public String companyIDPassSearch(CompanyDTO dto);

	// 로그인-사용자 정보 검색
	public CompanyDTO companyLogin(CompanyDTO dto);

}
