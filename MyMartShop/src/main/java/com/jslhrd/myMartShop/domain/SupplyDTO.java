package com.jslhrd.myMartShop.domain;

import lombok.Data;

@Data
public class SupplyDTO {
	private int s_id;
	private String supplyDate;
	private int s_amount;
	private int g_id;
	private String c_name;
}
