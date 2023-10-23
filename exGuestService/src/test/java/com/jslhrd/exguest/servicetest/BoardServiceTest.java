package com.jslhrd.exguest.servicetest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jslhrd.exguest.service.GuestService;

@SpringBootTest
public class BoardServiceTest {
	private static Logger log = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Autowired
	private GuestService service ;
	
	@Test
	public void boardCountTest() {
		log.info("Service totCount : " + service.guestCount());
	}
	
}
