package com.yh.libraryapp.book.model.dao.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.yh.libraryapp.book.model.dao.BookMapper;
import com.yh.libraryapp.book.model.vo.BookVO;
import com.yh.libraryapp.member.model.dao.MemberMapper;
import com.yh.libraryapp.member.model.vo.MemberVO;

class myBatisTest {

	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config-test.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void findAllBookTest() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<BookVO> books = mapper.findAllBook();
			System.out.println(books);
		}
	}

}
