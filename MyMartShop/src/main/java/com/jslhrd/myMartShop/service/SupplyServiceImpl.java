package com.jslhrd.myMartShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.myMartShop.mapper.SupplyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplyServiceImpl implements SupplyService {

	@Autowired
	private SupplyMapper mapper;
	
}
