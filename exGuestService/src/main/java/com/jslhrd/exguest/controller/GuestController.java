package com.jslhrd.exguest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jslhrd.exguest.domain.GuestDTO;
import com.jslhrd.exguest.service.GuestService;

@Controller
@RequestMapping("Guest")
public class GuestController {
	private static final Logger log = 
			LoggerFactory.getLogger(GuestController.class);

	@Autowired
	private GuestService service;
	
	@GetMapping("guest_list")
	public void guestList(Model model) {
		log.info("Call  :  guest_list ");
		model.addAttribute("totcount", service.guestCount());
		model.addAttribute("list", service.guestList());
	}
	
	//등록 폼
	@GetMapping("guest_write")
	public void guestWrite() {
		log.info("Call  :  guest_write ");
	}
	//등록처리
	@PostMapping("guest_write")
	public String guestWritePro(GuestDTO dto) {
		log.info("Call  :  guest_write ");
		log.info("dto  :  " + dto);
		service.guestWrite(dto);
		
		return "redirect:guest_list";//Controller 경로
	}
	
/*
	//등록처리
	@PostMapping("guest_write")
	public String guestWritePro(GuestDTO dto, Model model) {
		int row = mapper.guestWrite(dto);
		model.addAttribute("row", row);
		log.info("Call  :  guest_write 등록처리" );
		
		return "Guest/guest_write_pro";//jsp 경로
	}
*/
	@GetMapping("guest_hits")
	public String guestHits(@RequestParam("idx") int idx, HttpServletRequest request, HttpServletResponse response) {
		log.info("Call  :  guest_hits");
		service.guestHits(idx, request, response);
		
		return "redirect:guest_view?idx="+idx;
		
	}
	@GetMapping("guest_view")
	public void guestView(@RequestParam("idx") int idx, Model model) {
		log.info("Call  :  guest_view ");
		model.addAttribute("guest", service.guestSearch(idx));
		
	}
	
	
	//수정 폼
	@GetMapping("guest_modify")
	public void guestModify(@RequestParam("idx") int idx, Model model) {
		log.info("Call  :  guest_modify ");
		model.addAttribute("guest", service.guestSearch(idx));
	}
	
	//수정처리
	@PostMapping("guest_modify")
	public String guestModifyPro(GuestDTO guest) {
		log.info("Call  :  guest_modify_pro ");
		log.info("dto  :  " + guest);
		service.guestModify(guest);
		
		return "redirect:guest_list";
	}
	
	//삭제
	@GetMapping("guest_delete")
	public String guestDelete(@RequestParam("idx") int idx) {
		log.info("Call  :  guest_delete ");
		service.guestDelete(idx);
		return "redirect:guest_list";
	}

}
