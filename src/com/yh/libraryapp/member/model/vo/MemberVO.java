package com.yh.libraryapp.member.model.vo;

import java.sql.Date;

public class MemberVO {
	private int mem_num;
	private String mem_name;		
	private String mem_email;		
	private String pwd;				
	private String confirm_pwd;		
	private String lib_regi_name;
	private int loan_num;
	private int rsr_num;
	private Date due_date;
	private Date mtl_loan_date;
	
	public MemberVO(int mem_num, String mem_name, String mem_email, String pwd, String confirm_pwd,
			String lib_regi_name, int loan_num, int rsr_num, Date due_date, Date mtl_loan_date) {
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.pwd = pwd;
		this.confirm_pwd = confirm_pwd;
		this.lib_regi_name = lib_regi_name;
		this.loan_num = loan_num;
		this.rsr_num = rsr_num;
		this.due_date = due_date;
		this.mtl_loan_date = mtl_loan_date;
	}
	
	public int getMem_num() {
		return mem_num;
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
	public int getLoan_num() {
		return loan_num;
	}
	public int getRsr_num() {
		return rsr_num;
	}
	public Date getDue_date() {
		return due_date;
	}
	public Date getMtl_loan_date() {
		return mtl_loan_date;
	}

	@Override
	public String toString() {
		return "MemberVO [mem_num=" + mem_num + ", mem_name=" + mem_name + ", mem_email=" + mem_email + ", pwd=" + pwd
				+ ", confirm_pwd=" + confirm_pwd + ", lib_regi_name=" + lib_regi_name + ", loan_num=" + loan_num
				+ ", rsr_num=" + rsr_num + ", due_date=" + due_date + ", mtl_loan_date=" + mtl_loan_date + "]";
	}
	
	
}
