package com.yh.libraryapp.book.model.dao.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.yh.libraryapp.book.model.vo.BookVO;
import com.yh.libraryapp.book.model.vo.type.LoanYNType;
import com.yh.libraryapp.book.model.vo.BookDetailVO;
import com.yh.libraryapp.book.model.vo.BookOwnVO;
import com.yh.libraryapp.member.model.vo.MemberVO;

class myBatisTest {

	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	@Disabled
	public void findAllBookTest() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			List<BookVO> books = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findAllBook");
			System.out.println(books);
		}
	}
	
	@Test
	@Disabled
	public void findByLibNameTest() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			List<BookVO> books = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findByLibName","충남대학교 도서관");
			System.out.println(books);
		}
	}
	
	@Test
	@Disabled
	public void findByContentTest() {
		String book_name = "대림";
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			
			List<BookVO> books = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findByContent",book_name);
			System.out.println(books);
		}
	}
	
	@Test
	@Disabled
	public void findByContentsTest() {
		String lib_name="충남대학교 도서관";
		String book_name = "자바";
		String author_name = "김창환";
		String pub_com = "대림";
		Integer pub_year_start = 2000;
		Integer pub_year_end = 2007;
		
		Map<String,Object> hashmap = new HashMap<String, Object>();
		hashmap.put("lib_name", lib_name);
		hashmap.put("book_name", book_name);
		hashmap.put("author_name", author_name);
		hashmap.put("pub_com",pub_com);
		//hashmap.put("pub_year_start", pub_year_start);
		//hashmap.put("pub_year_end", pub_year_end);
		
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			
			List<BookVO> books = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findByContents",hashmap);
			books.stream().forEach(item->System.out.println(item));
		}
	}
	
	@Test
	@Disabled
	public void findByBookNameTest() {
		//String book_name = "(Power) Java";
		String book_name = "HTML + 자바스크립트:30일 완성";
		BookDetailVO book = null;
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){	
			book = sqlSession.selectOne("com.yh.libraryapp.book.model.dao.BookMapper.findByBookName",book_name);
			System.out.println(book);
		}
	}
	
	@Test
	@Disabled
	public void findBookOwnInfoByBookName() {
		List<BookOwnVO> bookOwnInfos = null;
		String book_name = "(Power) Java";
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){	
			bookOwnInfos = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findBookOwnInfoByBookName",book_name);
			System.out.println(bookOwnInfos);
		}
	}
	
	@Test
	@Disabled
	public void findBookOwnInfoByBookName2() {
		List<BookOwnVO> bookOwnInfos = null;
		String book_name = "HTML + 자바스크립트:30일 완성";
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){	
			bookOwnInfos = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findBookOwnInfoByBookName",book_name);
			System.out.println(bookOwnInfos);
		}
	}
	
	@Test
	public void book_loan_dateTest() {
		LocalDateTime dateTime = LocalDateTime.now();
		Date book_loan_date = Date.valueOf(dateTime.toLocalDate());
		Date book_rtn_expt_date = Date.valueOf(dateTime.plusDays(10).toLocalDate());
		
		System.out.println(book_loan_date);
		System.out.println(book_rtn_expt_date);
	}


}
