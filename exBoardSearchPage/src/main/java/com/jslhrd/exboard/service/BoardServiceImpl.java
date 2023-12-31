package com.jslhrd.exboard.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.exboard.domain.BoardDTO;
import com.jslhrd.exboard.domain.PageDTO;
import com.jslhrd.exboard.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public int boardCount() {
		return mapper.boardCount();
	}
	@Override
	public int boardCountSearch(PageDTO dto) {
		return mapper.boardCountSearch(dto);
	}
/*
	@Override
	public List<BoardDTO> boardList() {
		return mapper.boardList();
	}
*/
	//전체검색(페이지 O, 검색X)
	@Override
	public List<BoardDTO> boardList(PageDTO dto) {
		return mapper.boardList(dto);
	}
	//전체검색(페이지 O, 검색O)
	@Override
	public List<BoardDTO> boardListSearch(PageDTO dto) {
		return mapper.boardListSearch(dto);
	}
	
	@Override
	public void boardHits(int idx, HttpServletRequest request, HttpServletResponse response) {
		//쿠키설정
		boolean bool=false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; i<cookies.length; i++) {
			info =cookies[i];
			if(info.getName().equals("boardCookie"+idx)) {
				bool = true;
				break;
			}
		}
		String str="" + System.currentTimeMillis();
		if(!bool) {
			info = new Cookie("boardCookie"+idx, str);
			info.setMaxAge(60*5);//5분
			response.addCookie(info);
			mapper.boardHits(idx);		
		}

	}

	@Override
	public BoardDTO boardSelect(int idx) {
		return mapper.boardSelect(idx);
	}

	@Override
	public int boardWrite(BoardDTO dto) {
		return mapper.boardWrite(dto);
	}

	@Override
	public int boardModify(BoardDTO dto) {
		return mapper.boardModify(dto);
	}

	@Override
	public int boardDelete(BoardDTO dto) {
		return mapper.boardDelete(dto);
	}

}
