package com.yh.libraryapp.book.model.vo;

import java.sql.Date;

public class BookRsrVO {
	private int book_rsr_num;
	private int lib_regi_num;
	private int book_regi_num;
	private int mem_num;
	private int book_rsr_prity_num;
	
	public BookRsrVO(int book_rsr_num, int lib_regi_num, int book_regi_num, int mem_num, int book_rsr_prity_num) {
		this.book_rsr_num = book_rsr_num;
		this.lib_regi_num = lib_regi_num;
		this.book_regi_num = book_regi_num;
		this.mem_num = mem_num;
		this.book_rsr_prity_num = book_rsr_prity_num;
	}

	public BookRsrVO(Builder builder) {
		this.book_rsr_num = builder.book_rsr_num;
		this.lib_regi_num = builder.lib_regi_num;
		this.book_regi_num = builder.book_regi_num;
		this.mem_num = builder.mem_num;
		this.book_rsr_prity_num = builder.book_rsr_prity_num;
	}
	
	public static class Builder{
		private int book_rsr_num;
		private int lib_regi_num;
		private int book_regi_num;
		private int mem_num;
		private int book_rsr_prity_num;
		
		public Builder(int book_rsr_num){
			this.book_rsr_num = book_rsr_num;
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
		
		public Builder book_rsr_prity_num(int book_rsr_prity_num) {
			this.book_rsr_prity_num = book_rsr_prity_num;
			return this;
		}
		
		public BookRsrVO build() {
			return new BookRsrVO(this);
		}
	}

	public int getBook_rsr_num() {
		return book_rsr_num;
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

	public int getBook_rsr_prity_num() {
		return book_rsr_prity_num;
	}

	@Override
	public String toString() {
		return "BookRsrVO [book_rsr_num=" + book_rsr_num + ", lib_regi_num=" + lib_regi_num + ", book_regi_num="
				+ book_regi_num + ", mem_num=" + mem_num + ", book_rsr_prity_num=" + book_rsr_prity_num + "]";
	}

}
