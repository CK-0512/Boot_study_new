package com.jslhrd.myMartShop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jslhrd.myMartShop.service.IndentService;


@Controller
@RequestMapping("Order")
public class IndentController {
	private Logger log = 
			LoggerFactory.getLogger(IndentController.class);

	@Autowired
	private IndentService service;
}
