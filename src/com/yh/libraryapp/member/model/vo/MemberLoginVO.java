package com.yh.libraryapp.member.model.vo;

public class MemberLoginVO {
	private String mem_email;
	private String pwd;
	
	public MemberLoginVO(String mem_email, String pwd) {
		this.mem_email = mem_email;
		this.pwd = pwd;
	}
	
	public String getMem_email() {
		return mem_email;
	}
	public String getPwd() {
		return pwd;
	}

	@Override
	public String toString() {
		return "MemberLoginVO [mem_email=" + mem_email + ", pwd=" + pwd + "]";
	}
	
	
}