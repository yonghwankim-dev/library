package com.yh.libraryapp.library.model.dao.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.yh.libraryapp.library.model.vo.LibraryVO;
import com.yh.libraryapp.library.model.vo.type.LibNameType;
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
	public void findAllLibraryTest(){	
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			List<LibraryVO> librarys = session.selectList("com.yh.libraryapp.library.model.dao.LibraryMapper.findAllLibrary");
			
			System.out.println(librarys);
		}
	}
	
	@Test
	public void LibNameTypeTest() {
		int lib_regi_num = LibNameType.valueOf("충남대학교").getValue();
		System.out.println(lib_regi_num);
	}
}
