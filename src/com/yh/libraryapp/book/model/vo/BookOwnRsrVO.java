package com.yh.libraryapp.book.model.vo;

import java.sql.Date;

import com.yh.libraryapp.book.model.vo.type.LoanYNType;

public class BookOwnRsrVO {
	private int book_regi_num;	// 도서 등록번호
	private String lib_name;	// 도서관명
	private LoanYNType loan_yn;		// 도서상태 : 대출가능/대출중
	private Date book_rtn_expt_date;	// 반납예정일
	private int mem_num;				// 대출자의 회원번호
	
	public BookOwnRsrVO() {
		
	}

	
		
}
