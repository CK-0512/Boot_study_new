package com.jslhrd.exguest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jslhrd.exguest.domain.GuestDTO;

@Mapper
public interface GuestMapper {
	//전체 게시글 수 카운트
	public int guestCount();
	
	//게시글 전체 목록
	public List<GuestDTO> guestList();
}
