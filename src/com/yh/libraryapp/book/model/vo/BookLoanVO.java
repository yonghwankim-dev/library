package com.yh.libraryapp.book.model.vo;

import java.sql.Date;

public class BookLoanVO {
	private int book_loan_num;
	private int lib_regi_num;
	private int book_regi_num;
	private int mem_num;
	private Date book_loan_date;
	private int book_loan_extn_num;
	private Date book_rtn_expt_date;
	
	public BookLoanVO(int book_loan_num, int lib_regi_num, int book_regi_num, int mem_num, Date book_loan_date,
			int book_loan_extn_num, Date book_rtn_expt_date) {
		this.book_loan_num = book_loan_num;
		this.lib_regi_num = lib_regi_num;
		this.book_regi_num = book_regi_num;
		this.mem_num = mem_num;
		this.book_loan_date = book_loan_date;
		this.book_loan_extn_num = book_loan_extn_num;
		this.book_rtn_expt_date = book_rtn_expt_date;
	}

	public BookLoanVO(Builder builder) {
		this.book_loan_num = builder.book_loan_num;
		this.lib_regi_num = builder.lib_regi_num;
		this.book_regi_num = builder.book_regi_num;
		this.mem_num = builder.mem_num;
		this.book_loan_date = builder.book_loan_date;
		this.book_loan_extn_num = builder.book_loan_extn_num;
		this.book_rtn_expt_date = builder.book_rtn_expt_date;
	}
	
	public static class Builder{
		private int book_loan_num;
		private int lib_regi_num;
		private int book_regi_num;
		private int mem_num;
		private Date book_loan_date;
		private int book_loan_extn_num;
		private Date book_rtn_expt_date;
		
		public Builder(int book_loan_num){
			this.book_loan_num = book_loan_num;
		}
		
		public Builder lib_regi_num(int lib_regi_num) {
			this.lib_regi_num = lib_regi_num;
			return this;
		}
		
		public Builder book_regi_num(int book_regi_num) {
			this.book_regi_num = book_regi_num;
			return this;
		}
		
		public Builder mem_num(int mem_num) {
			this.mem_num = mem_num;
			return this;
		}
		
		public Builder book_loan_date(Date book_loan_date) {
			this.book_loan_date = book_loan_date;
			return this;
		}
		
		public Builder book_loan_extn_num(int book_loan_extn_num) {
			this.book_loan_extn_num = book_loan_extn_num;
			return this;
		}
		
		public Builder book_rtn_expt_date(Date book_rtn_expt_date) {
			this.book_rtn_expt_date = book_rtn_expt_date;
			return this;
		}
		
		public BookLoanVO build() {
			return new BookLoanVO(this);
		}
	}

	public int getBook_loan_num() {
		return book_loan_num;
	}

	public int getLib_regi_num() {
		return lib_regi_num;
	}

	public int getBook_regi_num() {
		return book_regi_num;
	}

	public int getMem_num() {
		return mem_num;
	}

	public Date getBook_loan_date() {
		return book_loan_date;
	}

	public int getBook_loan_extn_num() {
		return book_loan_extn_num;
	}

	public Date getBook_rtn_expt_date() {
		return book_rtn_expt_date;
	}

	@Override
	public String toString() {
		return "BookLoanVO [book_loan_num=" + book_loan_num + ", lib_regi_num=" + lib_regi_num + ", book_regi_num="
				+ book_regi_num + ", mem_num=" + mem_num + ", book_loan_date=" + book_loan_date
				+ ", book_loan_extn_num=" + book_loan_extn_num + ", book_rtn_expt_date=" + book_rtn_expt_date + "]";
	}	
}
