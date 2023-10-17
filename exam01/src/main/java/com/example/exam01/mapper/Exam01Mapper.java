package com.example.exam01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Exam01Mapper {
	//현재 날짜와 시간을 출력하는 메소드
	
	@Select("SELECT sysdate FROM DUAL")
	public String getTime();
}
