package com.jslhrd.exMember.mappertest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jslhrd.exMember.mapper.MemberMapper;

@SpringBootTest
public class MemberMapperTest {
	private Logger 
			log = LoggerFactory.getLogger(MemberMapperTest.class);
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void memberCountTest() {
		int totcount = mapper.memberCount();
		log.info("totcount = " + totcount);
	}
}
