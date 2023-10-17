package com.example.exam01.mapperTest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.exam01.dbTest.Datasource;
import com.example.exam01.mapper.Exam01Mapper;
import com.example.exam01.mapper.Exam01Mapper2;

@SpringBootTest
public class MapperTest {
	private static final Logger log = LoggerFactory.getLogger(Datasource.class);
	
	@Autowired
	private Exam01Mapper mapper;
	
	@Autowired
	private Exam01Mapper2 mapper2;

	@Test
	public void mpTest() throws Exception {
		log.info(mapper.getTime());
	}
	
	@Test
	public void mpTest2() throws Exception {
		log.info(mapper2.getTime());
	}
}
