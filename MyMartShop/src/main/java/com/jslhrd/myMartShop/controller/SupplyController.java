package com.jslhrd.myMartShop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jslhrd.myMartShop.service.SupplyService;


@Controller
@RequestMapping("Supply")
public class SupplyController {
	private Logger log = 
			LoggerFactory.getLogger(SupplyController.class);

	@Autowired
	private SupplyService service;
}
