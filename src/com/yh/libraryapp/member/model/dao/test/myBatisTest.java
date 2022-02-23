package com.yh.libraryapp.member.model.dao.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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
	public void gettingStarted(){	
		String mem_email = "user1@gmail.com";
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			MemberVO member =  session.selectOne("MemberMapper.login",mem_email);
			System.out.println(member);
		}
	}
	
	@Test
	@Disabled
	public void loginTest(){	
		String mem_email = "user1@gmail.com";
		String pwd = "tmvlzj";
		MemberVO m = new MemberVO.Builder(-1)
								.mem_email(mem_email)
								.pwd(pwd)
								.build();
		try(SqlSession session = sqlSessionFactory.openSession()){
			MemberVO member =  session.selectOne("com.yh.libraryapp.member.model.dao.MemberMapper.findByEmailAndPwd",m);
			System.out.println(member);
		}
	}
	
	@Test
	public void signUpTest(){
		String mem_pwd = "user15";
		String mem_email = "user15@gmail.com";
		String mem_name = "이신";
		int lib_regi_num = 1;
		MemberVO member = new MemberVO.Builder(-1)
										.pwd(mem_pwd)
										.mem_email(mem_email)
										.mem_name(mem_name)
										.lib_regi_num(lib_regi_num)
										.build();
		
		int insertResult = 0;
		boolean result = false;
		try(SqlSession session = sqlSessionFactory.openSession()){
			insertResult = session.insert("com.yh.libraryapp.member.model.dao.MemberMapper.insert",member);
			result = insertResult > 0 ? true : false;
			//session.commit();
		}catch (Exception e) {
			result = false;
		}finally {
			if(result)
			{
				System.out.println("회원가입 성공");
			}
			else
			{
				System.out.println("회원가입 실패 : 중복된 메일이 존재합니다.");
			}
		}
	}

}
