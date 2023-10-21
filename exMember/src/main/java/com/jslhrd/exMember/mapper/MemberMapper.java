package com.jslhrd.exMember.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jslhrd.exMember.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	//전체게시글 카운트
	public int memberCount();

	//전체게시글 목록
	public List<MemberDTO> memberList();
	
	//글 등록
	public int memberWrite(MemberDTO member);

	//특정글 조회수 증가(View)
	public void memberHits(int idx);

	//특정글 검색(idx), View, Modify
	public MemberDTO memberSelect(int idx);
	
	//글 수정
	public int memberModify(MemberDTO member);
	
	//특정글 삭제 
	public int memberDelete(MemberDTO member);


}
