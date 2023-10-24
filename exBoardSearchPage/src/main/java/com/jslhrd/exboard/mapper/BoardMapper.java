package com.jslhrd.exboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jslhrd.exboard.domain.BoardDTO;
import com.jslhrd.exboard.domain.PageDTO;

@Mapper
public interface BoardMapper {
	//전체게시글 카운트
	public int boardCount();
	//전체게시글 카운트(검색)
	public int boardCountSearch(PageDTO dto);

	
	/*
	//전체게시글 목록(페이지 X, 검색 X)
	public List<BoardDTO> boardList();
*/
	
	//전체게시글 목록(페이지 O, 검색X)
	public List<BoardDTO> boardList(PageDTO dto);
	//전체게시글 목록(페이지 O, 검색O)
	public List<BoardDTO> boardListSearch(PageDTO dto);

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
