package com.jslhrd.myMartShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.myMartShop.domain.MemberDTO;
import com.jslhrd.myMartShop.mapper.MemberMapper;
import com.jslhrd.myMartShop.util.UserSha256;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int memberIDCheck(String memberid) {
		return mapper.memberIDCheck(memberid);
	}
	
	@Override
	public int memberInsert(MemberDTO dto) {
		String pass = UserSha256.encrypt(dto.getPass());
		dto.setPass(pass);
		
		String tel = dto.getM_tel();
		if(tel.length()>11) {
			tel = tel.replace("-", ""); 
		}
		dto.setM_tel(tel);
		
		return mapper.memberInsert(dto);
	}
	
	@Override
	public String memberIDPassSearch(MemberDTO dto) {
		return mapper.memberIDPassSearch(dto);
	}
	
	@Override
	public MemberDTO memberLogin(MemberDTO dto) {
		return mapper.memberLogin(dto);
	}
	
	@Override
	public void memberLoginUpdate(MemberDTO dto) {
		mapper.memberLoginUpdate(dto);
	}
	
	@Override
	public List<MemberDTO> memberList() {
		return mapper.memberList();
	}
	
	@Override
	public int memberDelete(String memberid) {
		return mapper.memberDelete(memberid);
	}
}
