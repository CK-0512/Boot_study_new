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

import com.jslhrd.myMartShop.domain.CompanyDTO;
import com.jslhrd.myMartShop.service.CompanyService;
import com.jslhrd.myMartShop.util.UserSha256;

@Controller
@RequestMapping("Usr/Company")
public class CompanyController {
	private Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService service;

	// 로그인 폼
	@GetMapping("companyLogin")
	public String companyLogin(HttpSession session, Model model) {
		if (session.getAttribute("company") == null) {
			return "/Usr/Company/companyLogin";
		} else {
			model.addAttribute("row", 1);
			return "redirect:../../";
		}
	}
	// 로그인 처리
	@PostMapping("companyLogin")
	public String companyLoginPro(CompanyDTO dto, Model model, HttpServletRequest request) {
		String pass = service.companyIDPassSearch(dto);
		if (pass == null) {
			model.addAttribute("row", -1);
			return "/Usr/Company/companyLogin_ok";
		} else {
			if (pass.equals(dto.getCorNum())) {
				request.getSession().setAttribute("company", service.companyLogin(dto));
				request.getSession().setMaxInactiveInterval(1800);
				model.addAttribute("row", 1);
				return "/Usr/Company/companyLogin_ok";
			} else {
				model.addAttribute("row", 0);
				return "/Usr/Company/companyLogin_ok";
			}
		}
	}
}
