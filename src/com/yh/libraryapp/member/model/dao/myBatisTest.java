package com.yh.libraryapp.member.model.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.catalina.mapper.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.yh.libraryapp.config.MemberMapper;
import com.yh.libraryapp.member.model.vo.MemberLoginVO;

class myBatisTest {

	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeEach
	public void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config-test.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	@Disabled
	public void gettingStarted(){	
		String mem_email = "user1@gmail.com";
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			MemberLoginVO member =  session.selectOne("MemberMapper.login",mem_email);
			System.out.println(member);
		}
	}
	
	@Test
	public void gettingStartedWithoutXML(){	
		String mem_email = "user1@gmail.com";
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			MemberLoginVO member =  mapper.login(mem_email);
			System.out.println(member);
		}
	}
}
