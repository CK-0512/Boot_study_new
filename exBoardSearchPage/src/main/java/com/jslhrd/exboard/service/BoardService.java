package com.jslhrd.exboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.exboard.domain.BoardDTO;
import com.jslhrd.exboard.domain.PageDTO;

public interface BoardService {
	// 전체 게시글 수 카운트
	public int boardCount();
	// 전체 게시글 수 카운트
	public int boardCountSearch(PageDTO dto);

/*	
	//글전체 목록(페이지 X, 검색 X)
	public List<BoardDTO> boardList();
*/
	//글전체 목록(페이지 O, 검색 X)
	public List<BoardDTO> boardList(PageDTO dto);
	//글전체 목록(페이지 O, 검색 X)
	public List<BoardDTO> boardListSearch(PageDTO dto);
	
	//글 조회수 증가
	public void boardHits(int idx, HttpServletRequest request, HttpServletResponse response);
	
	//특정글 검색(view, modify)
	public BoardDTO boardSelect(int idx);
	
	//글 등록
	public int boardWrite(BoardDTO dto);
	
	//수정
	public int boardModify(BoardDTO dto);
	
	//삭제
	public int boardDelete(BoardDTO dto);
	
}
