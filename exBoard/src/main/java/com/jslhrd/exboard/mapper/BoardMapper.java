package com.jslhrd.exboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jslhrd.exboard.domain.BoardDTO;

@Mapper
public interface BoardMapper {
	//전체게시글 카운트
	public int boardCount();

	//전체게시글 목록
	public List<BoardDTO> boardList();
	
	//글 등록
	public int boardWrite(BoardDTO board);

	//특정글 조회수 증가(View)
	public void boardHits(int idx);

	//특정글 검색(idx), View, Modify
	public BoardDTO boardSelect(int idx);
	
	//글 수정
	public int boardModify(BoardDTO board);
	
	//특정글 삭제 
	public int boardDelete(BoardDTO board);


}
