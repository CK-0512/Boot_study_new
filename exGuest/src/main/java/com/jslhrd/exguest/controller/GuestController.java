package com.jslhrd.exguest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jslhrd.exguest.mapper.GuestMapper;

@Controller
@RequestMapping("Guest")
public class GuestController {
	private static final Logger log =
			LoggerFactory.getLogger(GuestController.class);

	@Autowired
	private GuestMapper mapper;
	
	@RequestMapping("/guest_list")
	public void guestList(Model model) {
		int cnt = mapper.guestCount();
		model.addAttribute("count", cnt);
		
		//List<GuestDTO> list = mapper.guestList();
		//model.addAttribute("list", list);
		model.addAttribute("list", mapper.guestList());
	}
	
}
