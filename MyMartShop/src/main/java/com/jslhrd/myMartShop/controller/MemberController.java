package com.jslhrd.myMartShop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jslhrd.myMartShop.domain.MemberDTO;
import com.jslhrd.myMartShop.service.MemberService;
import com.jslhrd.myMartShop.util.UserSha256;


@Controller
@RequestMapping("Usr/Member")
public class MemberController {
	private Logger log = 
			LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService service;
	
	//로그인 폼
	@GetMapping("memberLogin")
	public String memberLogin(HttpSession session, Model model) {
		 if(session.getAttribute("member") == null) {
			 return "/Usr/Member/memberLogin";
		 }else {
			 model.addAttribute("row", 1);
			 return "redirect:../../";
		 }
	}

	//로그인 처리
	@PostMapping("memberLogin")
	public String memberLoginPro(MemberDTO dto, Model model, HttpServletRequest request) {
		String pass = service.memberIDPassSearch(dto);
		if(pass == null) {
			model.addAttribute("row", -1);
			return "/Usr/Member/memberLogin_ok";
		}else {
			if(pass.equals(UserSha256.encrypt(dto.getPass()))) {
				request.getSession().setAttribute("member", service.memberLogin(dto));
				request.getSession().setMaxInactiveInterval(1800);
				model.addAttribute("row", 1);
				service.memberLoginUpdate(dto);
				return "/Usr/Member/memberLogin_ok";
			}else { 
				model.addAttribute("row", 0);
				return "/Usr/Member/memberLogin_ok";
			}
		}
	}
	
	//로그아웃
	@GetMapping("memberLogout")
	public void MemberLogout(HttpSession session) {
		session.invalidate();
	}
	
	//회원가입 폼
	@GetMapping("memberInfo_insert")
	public void memberInfo_insert() {
		 
	}
	
	//아이디 중복검사
	@ResponseBody
	@PostMapping("member_idcheck")
	public String memberIDCheck(@RequestParam("memberid") String memberid) {
		int row = service.memberIDCheck(memberid);
		return String.valueOf(row);
	}
	
	//회원가입 처리
	@PostMapping("memberInfo_insert")
	public String memberInfo_insert_pro(MemberDTO dto) {
		int row = service.memberInsert(dto);
		return "redirect:";
	}

}
