package com.jslhrd.myMartShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.myMartShop.mapper.ArticleMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper mapper;
	
}
