package com.example.exDBTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.exDBTest.domain.TestDTO;

@Controller
public class TestController {
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index2() {
		return "index";
	}
	
	@GetMapping("/test")
	public void test(@ModelAttribute("idx") int idx, @ModelAttribute("page") int page) {
		log.info("idx = " + idx);
		log.info("page = " + page);
	}
	
	@GetMapping("/test2")
	public void test2(int idx, int page) {
		log.info("idx = " + idx);
		log.info("page = " + page);
	}
	
	@GetMapping("/test3")
	public void test3(TestDTO dto) {
		log.info("dto = " + dto);
	}
}
