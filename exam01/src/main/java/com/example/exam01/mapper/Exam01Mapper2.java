package com.example.exam01.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Exam01Mapper2 {
	//현재 날짜와 시간을 출력하는 메소드
	
	public String getTime();
}
