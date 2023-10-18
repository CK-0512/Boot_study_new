package com.jslhrd.exguest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jslhrd.exguest.domain.GuestDTO;

@Mapper
public interface GuestMapper {
	//전체 게시글 수 카운트
	public int guestCount();
	
	//전체 글 목록
	public List<GuestDTO> guestList();
	
	//글 등록
	public int guestWrite(GuestDTO dto);
	
	//idx에 해당하는 글 검색(view에서 사용)
	public GuestDTO guestSearch(int idx);
	
	//수정처리
	public int guestModify(GuestDTO dto);
	
	//삭제
	public int guestDelete(int idx);
	
}
