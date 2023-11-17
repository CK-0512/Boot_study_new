package com.jslhrd.myMartShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.myMartShop.domain.CompanyDTO;
import com.jslhrd.myMartShop.mapper.CompanyMapper;
import com.jslhrd.myMartShop.util.UserSha256;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper mapper;

	@Override
	public int companyIDCheck(String c_name) {
		return mapper.companyIDCheck(c_name);
	}

	@Override
	public String companyIDPassSearch(CompanyDTO dto) {
		return mapper.companyIDPassSearch(dto);
	}

	@Override
	public CompanyDTO companyLogin(CompanyDTO dto) {
		return mapper.companyLogin(dto);
	}
}
