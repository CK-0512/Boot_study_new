package com.jslhrd.myMartShop.domain;

import lombok.Data;

@Data
public class CompanyDTO {
	String c_name; //제조사
	String corNum; //법인번호
	String c_tel; //연락처
	String location; //위치
	String manager; //담당자
}
