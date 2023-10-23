package com.jslhrd.exguest.mappertest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jslhrd.exguest.mapper.GuestMapper;

@SpringBootTest
public class GuestMapperTest {
	private static final Logger log = 
			LoggerFactory.getLogger(GuestMapperTest.class);

	@Autowired
	private GuestMapper mapper;
/*	
	@Test
	public void guestCount() {
		int count = mapper.guestCount();
		log.info("Total Count : " + count);
	}
*/
	@Test
	public void guestList() {
		mapper.guestList().forEach(guest->log.info(guest.toString()));
	}

}
