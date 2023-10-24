package com.jslhrd.exboard.domain;

import lombok.Data;

@Data
public class PageDTO {
	// 검색용
	private String search;//제목, 내용, 이름
	private String key;
		
	// 페이지처리용
	private int startpage;
	private int endpage;

}
