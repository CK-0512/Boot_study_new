package com.jslhrd.exMember.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jslhrd.exMember.domain.MemberDTO;
import com.jslhrd.exMember.mapper.MemberMapper;

@Controller
@RequestMapping("Member")
public class MemberController {
	private Logger 
	log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberMapper mapper;
	
	@GetMapping("member_list")
	public void memberList(Model model) {
		model.addAttribute("totcount", mapper.memberCount());
		model.addAttribute("list", mapper.memberList());
		log.info("Call  :  member_list" );
	}
	//등록 폼
	@GetMapping("member_write")
	public void memberWrite() {
		log.info("Call  :  member_write" );
	}
	
	//등록처리
	@PostMapping("member_write")
	public String memberWritePro(MemberDTO member) {
		int row = mapper.memberWrite(member);
		log.info("Call  :  member_write 등록처리" );
		
		return "redirect:member_list";//Controller 수행
	}
/*
	//등록처리
	@PostMapping("member_write")
	public String memberWritePro(MemberDTO member, Model model) {
		int row = mapper.memberWrite(member);
		model.addAttribute("row", row);
		log.info("Call  :  member_write 등록처리" );
		
		return "Member/member_write_pro";//jsp 파일 경로(경구문구 출력)
	}
*/
	
	//삭제
	@GetMapping("member_delete")
	public void memberDelete(@ModelAttribute("idx") int idx) {
		log.info("Call  :  member_delete (삭제 폼)" );
	}
	
	//삭제처리
	@PostMapping("member_delete")
	public String memberDeletePro(MemberDTO dto, RedirectAttributes rttr) {
		log.info("Call  :  member_delete (삭제 처리)" );
		rttr.addFlashAttribute("row", mapper.memberDelete(dto));
		
		return "redirect:member_delete_pro";
	}

	//삭제처리 알림
	@GetMapping("member_delete_pro")
	public void memberDeletePass() {
		log.info("memberDeletePro() . OK.......");
	}
	
	
}
