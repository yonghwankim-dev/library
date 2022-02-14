package com.yh.libraryapp.config;

import org.apache.ibatis.annotations.Select;

import com.yh.libraryapp.member.model.vo.MemberLoginVO;


public interface MemberMapper {
	@Select("SELECT * FROM member WHERE mem_email = #{mem_email}")
	MemberLoginVO login(String mem_email);
}
