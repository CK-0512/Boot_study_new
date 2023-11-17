package com.jslhrd.myMartShop.domain;

import lombok.Data;

@Data
public class GoodsDTO {
	private int g_id;
	private String g_name;
	private String g_fileName;
	private int amount;
	private int price;
	private String regDate;
}
