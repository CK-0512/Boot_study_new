package com.jslhrd.myMartShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.myMartShop.mapper.IndentMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndentServiceImpl implements IndentService {

	@Autowired
	private IndentMapper mapper;
	
}
