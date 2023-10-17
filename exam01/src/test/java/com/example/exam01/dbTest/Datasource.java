package com.example.exam01.dbTest;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Datasource {
	private static final Logger log = LoggerFactory.getLogger(Datasource.class);
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void dbTest() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		
		Connection conn = session.getConnection();
		
		log.info("Connection : " +conn);
		log.info("SqlSession : " +session);
	}
}
