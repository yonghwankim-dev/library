package com.yh.libraryapp.member.model.vo;

public class MemberSignUpVO {
	private String mem_name;		// 회원 이름
	private String mem_email;		// 회원 이메일
	private String pwd;				// 비밀번호
	private String confirm_pwd;		// 비밀번호 확인
	private String lib_regi_name;	// 도서관 등록 이름

	public MemberSignUpVO(String mem_name, String mem_email, String pwd, String confirm_pwd, String lib_regi_name) {
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.pwd = pwd;
		this.confirm_pwd = confirm_pwd;
		this.lib_regi_name = lib_regi_name;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public String getPwd() {
		return pwd;
	}
	public String getConfirm_pwd() {
		return confirm_pwd;
	}
	public String getLib_regi_name() {
		return lib_regi_name;
	}
	
	
}