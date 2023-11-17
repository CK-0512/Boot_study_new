package com.jslhrd.myMartShop.domain;

import lombok.Data;

@Data
public class MemberDTO {
	private String memberid;
	private String pass;
	private String m_name;
	private String m_tel;
	private int age;
	private String job;
	private String grade;
	private int totalspent;
	private int point;
	private int authlevel;
	private String regdate;
	private String lastlogin;
}
