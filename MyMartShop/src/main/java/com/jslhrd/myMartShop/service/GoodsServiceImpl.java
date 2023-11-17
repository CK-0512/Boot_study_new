package com.jslhrd.myMartShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.myMartShop.mapper.GoodsMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper mapper;
	
}
