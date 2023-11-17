package com.jslhrd.myMartShop.domain;

import lombok.Data;

@Data
public class ArticleDTO {
	private int a_id;
	private String memberId;
	private String title;
	private String body;
	private String a_fileName;
	private String writeDate;
	private String hitCount;
	private int secret;
	private String type;
}
