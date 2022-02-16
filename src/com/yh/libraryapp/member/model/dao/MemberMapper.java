package com.yh.libraryapp.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.yh.libraryapp.member.model.vo.MemberVO;


public interface MemberMapper {
	@Select("select * from member where mem_email = #{mem_email} and pwd = #{pwd}")
	MemberVO findByEmailAndPwd(@Param("mem_email") String mem_email,@Param("pwd") String pwd);
	
	@Insert("insert into member(mem_num, pwd, mem_email, mem_name, lib_regi_num)"
			+" values (mem_num_seq.nextval, #{pwd}, #{mem_email}, #{mem_name}, #{lib_regi_num})")
	boolean insert(MemberVO member);
}
