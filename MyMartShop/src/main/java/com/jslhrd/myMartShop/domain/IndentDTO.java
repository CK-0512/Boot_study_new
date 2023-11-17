package com.jslhrd.myMartShop.domain;

import lombok.Data;

@Data
public class IndentDTO {
	private int i_id;
	private int i_amount;
	private String address;
	private String indentDate;
	private int totalPrice;
	private int g_id;
	private int memberId;
}
