package com.yh.libraryapp.book.model.vo;

import java.sql.Date;

public class BookRtnVO {
	private int book_rtn_num;
	private int lib_regi_num;
	private int book_regi_num;
	private int mem_num;
	private Date book_rtn_date;
	private int book_due_days;
	
	public BookRtnVO(int book_rtn_num, int lib_regi_num, int book_regi_num, int mem_num, Date book_rtn_date,
			int book_due_days) {
		this.book_rtn_num = book_rtn_num;
		this.lib_regi_num = lib_regi_num;
		this.book_regi_num = book_regi_num;
		this.mem_num = mem_num;
		this.book_rtn_date = book_rtn_date;
		this.book_due_days = book_due_days;
	}

	public BookRtnVO(Builder builder) {
		this.book_rtn_num = builder.book_rtn_num;
		this.lib_regi_num = builder.lib_regi_num;
		this.book_regi_num = builder.book_regi_num;
		this.mem_num = builder.mem_num;
		this.book_rtn_date = builder.book_rtn_date;
		this.book_due_days = builder.book_due_days;
	}
	
	public static class Builder{
		private int book_rtn_num;
		private int lib_regi_num;
		private int book_regi_num;
		private int mem_num;
		private Date book_rtn_date;
		private int book_due_days;
		
		public Builder(int book_rtn_num){
			this.book_rtn_num = book_rtn_num;
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
		
		public Builder book_rtn_date(Date book_rtn_date) {
			this.book_rtn_date = book_rtn_date;
			return this;
		}
		
		public Builder book_due_days(int book_due_days) {
			this.book_due_days = book_due_days;
			return this;
		}
		
		public BookRtnVO build() {
			return new BookRtnVO(this);
		}
	}

	public int getBook_rtn_num() {
		return book_rtn_num;
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

	public Date getBook_rtn_date() {
		return book_rtn_date;
	}

	public int getBook_due_days() {
		return book_due_days;
	}

	@Override
	public String toString() {
		return "BookRtnVO [book_rtn_num=" + book_rtn_num + ", lib_regi_num=" + lib_regi_num + ", book_regi_num="
				+ book_regi_num + ", mem_num=" + mem_num + ", book_rtn_date=" + book_rtn_date + ", book_due_days="
				+ book_due_days + "]";
	}

	
}
