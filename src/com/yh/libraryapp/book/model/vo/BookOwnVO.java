package com.yh.libraryapp.book.model.vo;

import java.sql.Date;

import com.yh.libraryapp.book.model.vo.type.LoanYNType;

// 도서 상세 페이지의 소장정보 도메인
public class BookOwnVO {
	private int book_regi_num;	// 도서 등록번호
	private String lib_name;	// 도서관명
	private LoanYNType loan_yn;		// 도서상태 : 대출가능/대출중
	private Date book_rtn_expt_date;	// 반납예정일
	private int mem_num;				// 대출자의 회원번호
	
	public BookOwnVO() {
		
	}
	
	public BookOwnVO(int book_regi_num, String lib_name, LoanYNType loan_yn, Date book_rtn_expt_date, int mem_num) {
		this.book_regi_num = book_regi_num;
		this.lib_name = lib_name;
		this.loan_yn = loan_yn;
		this.book_rtn_expt_date = book_rtn_expt_date;
		this.mem_num = mem_num;
	}

	public int getBook_regi_num() {
		return book_regi_num;
	}



	public String getLib_name() {
		return lib_name;
	}



	public LoanYNType getLoan_yn() {
		return loan_yn;
	}



	public Date getBook_rtn_expt_date() {
		return book_rtn_expt_date;
	}



	public int getMem_num() {
		return mem_num;
	}



	@Override
	public String toString() {
		return "BookOwnVO [book_regi_num=" + book_regi_num + ", lib_name=" + lib_name + ", loan_yn=" + loan_yn
				+ ", book_rtn_expt_date=" + book_rtn_expt_date + ", mem_num=" + mem_num + "]";
	}
	
		
}
