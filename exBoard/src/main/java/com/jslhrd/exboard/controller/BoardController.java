package com.jslhrd.exboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.exboard.domain.BoardDTO;
import com.jslhrd.exboard.mapper.BoardMapper;

@Controller
@RequestMapping("Board")
public class BoardController {
	private Logger 
	log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardMapper mapper;
	
	@GetMapping("board_list")
	public void boardList(Model model) {
		model.addAttribute("totcount", mapper.boardCount());
		model.addAttribute("list", mapper.boardList());
		log.info("Call  :  board_list" );
	}
	//등록 폼
	@GetMapping("board_write")
	public void boardWrite() {
		log.info("Call  :  board_write" );
	}
	
	//등록처리
	@PostMapping("board_write")
	public String boardWritePro(BoardDTO board) {
		int row = mapper.boardWrite(board);
		log.info("Call  :  board_write 등록처리" );
		
		return "redirect:board_list";//Controller 수행
	}
/*
	//등록처리
	@PostMapping("board_write")
	public String boardWritePro(BoardDTO board, Model model) {
		int row = mapper.boardWrite(board);
		model.addAttribute("row", row);
		log.info("Call  :  board_write 등록처리" );
		
		return "Board/board_write_pro";//jsp 파일 경로(경구문구 출력)
	}
*/
	//view
	@GetMapping("board_view")
	public void boardView(@RequestParam("idx") int idx, Model model) {
		mapper.boardHits(idx);//조회수 증가
		BoardDTO board = mapper.boardSelect(idx);
		board.setContents(board.getContents().replace("\n", "<br>"));
		model.addAttribute("board", board);
		log.info("Call  :  board_view" );
	}
	
	
	//삭제
	@GetMapping("board_delete")
	public void boardDelete(@ModelAttribute("idx") int idx) {
		log.info("Call  :  board_delete (삭제 폼)" );
	}
	
	//삭제처리
	@PostMapping("board_delete")
	public String boardDeletePro(BoardDTO dto, RedirectAttributes rttr) {
		log.info("Call  :  board_delete (삭제 처리)" );
		rttr.addFlashAttribute("row", mapper.boardDelete(dto));
		
		return "redirect:board_delete_pro";
	}

	//삭제처리 알림
	@GetMapping("board_delete_pro")
	public void boardDeletePass() {
		log.info("boardDeletePro() . OK.......");
	}
	
	
}
