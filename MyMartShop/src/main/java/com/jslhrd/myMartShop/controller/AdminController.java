package com.jslhrd.myMartShop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jslhrd.myMartShop.service.MemberService;

@Controller
@RequestMapping("Adm/Member")
public class AdminController {
	private Logger log = 
			LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private MemberService service;
	
	//회원목록 폼
	@GetMapping("memberList")
	public void memberList(Model model) {
		model.addAttribute("list", service.memberList());
		log.info("list  :  " + service.memberList());
	}
	
	//회원삭제
	@GetMapping("memberDelete")
	public void memberDelete(@RequestParam("memberid") String memberid, Model model) {
		int row = service.memberDelete(memberid);
		model.addAttribute("row", row);
	}
}
