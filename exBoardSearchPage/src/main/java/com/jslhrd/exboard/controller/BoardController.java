package com.jslhrd.exboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.exboard.domain.BoardDTO;
import com.jslhrd.exboard.domain.PageDTO;
import com.jslhrd.exboard.service.BoardService;
import com.jslhrd.exboard.util.PageIndex;

@Controller
@RequestMapping("Board")
public class BoardController {
	private Logger 
	log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
/*	
	//기본 전체 목록(페이지처리  X)
	@GetMapping("board_list")
	public void boardList(Model model) {
		log.info("Call  :  board_list" );
		model.addAttribute("totcount", service.boardCount());
		model.addAttribute("list", service.boardList());
	}
*/
	//기본 전체 목록(페이지처리  O, 검색 X)
	@GetMapping("board_list")
	public void boardList(@RequestParam("page") int page, PageDTO dto, Model model) {
		log.info("Call  :  board_list" );
		
		String url="board_list";
		
		int nowpage=1;
		int maxlist=10;
		int totpage=1;
		
		int totcount = service.boardCount();//총글 수
		//총 페이지수 계산
		if(totcount % 10 == 0)
			totpage = totcount / maxlist;
		else
			totpage = totcount / maxlist + 1;
		
		if(totpage==0)
			totpage=1;
		
		if(page !=0 )//페이지번호 클릭시
			nowpage=page;
		
		//현재 페이지 시작번호 구하기
		int startpage = (nowpage-1)*maxlist+1;
		int endpage = nowpage * maxlist;
		
		dto.setStartpage(startpage);
		dto.setEndpage(endpage);
		
		//게시글번호 출력용
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		model.addAttribute("page", nowpage);
		model.addAttribute("totcount", totcount);
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		
		model.addAttribute("list", service.boardList(dto));
		
		model.addAttribute("pageList", PageIndex.pageList(nowpage, totpage, url, ""));
	}

	//기본 전체 목록(페이지처리  O, 검색 X)
	@PostMapping("board_list")
	public void boardListPost(@RequestParam("page") int page, PageDTO dto, Model model) {
		log.info("Call  :  board_list" );
		
		String url="board_list";
		
		int nowpage=1;
		int maxlist=10;
		int totpage=1;
		
		int totcount = service.boardCountSearch(dto);//총글 수
		//총 페이지수 계산
		if(totcount % 10 == 0)
			totpage = totcount / maxlist;
		else
			totpage = totcount / maxlist + 1;
		
		if(totpage==0)
			totpage=1;
		
		if(page !=0 )//페이지번호 클릭시
			nowpage=page;
		
		//현재 페이지 시작번호 구하기
		int startpage = (nowpage-1)*maxlist+1;
		int endpage = nowpage * maxlist;
		
		dto.setStartpage(startpage);
		dto.setEndpage(endpage);
		
		//게시글번호 출력용
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		model.addAttribute("page", nowpage);
		model.addAttribute("totcount", totcount);
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		
		model.addAttribute("list", service.boardListSearch(dto));
		
		//model.addAttribute("pageList", PageIndex.pageList(nowpage, totpage, url, ""));
		model.addAttribute("pageList", PageIndex.pageListHan(nowpage, totpage, url, dto.getSearch(), dto.getKey()));
		
	}
	
	//기본 전체 목록(페이지처리  O, 검색 O)
	//Post & Get
	@RequestMapping(value="board_list", method= {RequestMethod.GET, RequestMethod.POST})
	public void boardListPostGet(@RequestParam("page") int page, PageDTO dto, Model model) {
		log.info("Call  :  board_list" );
		
		String url="board_list";
		
		int nowpage=1;
		int maxlist=10;
		int totpage=1;
		
		int totcount = 0;
		if(dto.getKey() != null) {
			totcount = service.boardCountSearch(dto);//총글 수
		}else {
			totcount = service.boardCount();//총글 수
		}
		//총 페이지수 계산
		if(totcount % 10 == 0)
			totpage = totcount / maxlist;
		else
			totpage = totcount / maxlist + 1;
		
		if(totpage==0)
			totpage=1;
		
		if(page !=0 )//페이지번호 클릭시
			nowpage=page;
		
		//현재 페이지 시작번호 구하기
		int startpage = (nowpage-1)*maxlist+1;
		int endpage = nowpage * maxlist;
		
		dto.setStartpage(startpage);
		dto.setEndpage(endpage);
		
		//게시글번호 출력용
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		model.addAttribute("page", nowpage);
		model.addAttribute("totcount", totcount);
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		if(dto.getKey() != null) {
			model.addAttribute("list", service.boardListSearch(dto));
		}else {
			model.addAttribute("list", service.boardList(dto));
		}
		//model.addAttribute("pageList", PageIndex.pageList(nowpage, totpage, url, ""));
		if(dto.getKey() != null) {
			model.addAttribute("pageList", PageIndex.pageListHan(nowpage, totpage, url, dto.getSearch(), dto.getKey()));
		}else {
			model.addAttribute("pageList", PageIndex.pageList(nowpage, totpage, url, ""));
		}
		
	}
	
	//등록 폼
	@GetMapping("board_write")
	public void boardWrite(@RequestParam("page") int page) {
		log.info("Call  :  board_write" );
	}
	
	//등록처리
	@PostMapping("board_write")
	public String boardWritePro(BoardDTO board, @RequestParam("page") int page) {
		int row = service.boardWrite(board);
		log.info("Call  :  board_write 등록처리" );
		
		return "redirect:board_list";//Controller 수행
	}
/*
	//등록처리
	@PostMapping("board_write")
	public String boardWritePro(BoardDTO board, Model model) {
		int row = service.boardWrite(board);
		model.addAttribute("row", row);
		log.info("Call  :  board_write 등록처리" );
		
		return "Board/board_write_pro";//jsp 파일 경로(경구문구 출력)
	}
*/
	//쿠키를 서비스에서 처리
	@GetMapping("board_hits")
	public String boardHits(@RequestParam("idx") int idx, @RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) {
		log.info("boardHits() ........");
		service.boardHits(idx, request, response);
		return "redirect:board_view?idx="+idx + "&page="+page;
	}
	
	//view
	@GetMapping("board_view")
	public void boardView(@RequestParam("idx") int idx, @RequestParam("page") int page, Model model) {
		log.info("Call  :  board_view" );
		//service.boardHits(idx);//조회수 증가
		BoardDTO board = service.boardSelect(idx);
		board.setContents(board.getContents().replace("\n", "<br>"));
		model.addAttribute("page", page);
		model.addAttribute("board", board);
	}
	
	//수정
	@GetMapping("board_modify")
	public void boardModify(@RequestParam("idx") int idx, @RequestParam("page") int page, Model model){
		log.info("Call  :  board_modify (수정 폼)" );
		model.addAttribute("board", service.boardSelect(idx));
	}
	//수정처리
	@PostMapping("board_modify")
	public String boardModifyPro(BoardDTO dto, @RequestParam("page") int page){
		log.info("Call  :  board_modify (수정 처리)" );
		service.boardModify(dto);
		return "redirect:board_list?page="+page;
	}
	
	//삭제
	@GetMapping("board_delete")
	public void boardDelete(@ModelAttribute("idx") int idx, @RequestParam("page") int page) {
		log.info("Call  :  board_delete (삭제 폼)" );
	}
	
	//삭제처리
	@PostMapping("board_delete")
	public String boardDeletePro(@RequestParam("page") int page, BoardDTO dto, RedirectAttributes rttr) {
		log.info("Call  :  board_delete (삭제 처리)" );
		rttr.addFlashAttribute("row", service.boardDelete(dto));
		rttr.addFlashAttribute("page", page);
		
		return "redirect:board_delete_pro";
	}

	//삭제처리 알림
	@GetMapping("board_delete_pro")
	public void boardDeletePass() {
		log.info("boardDeletePro() . OK.......");
	}
	
	
}
