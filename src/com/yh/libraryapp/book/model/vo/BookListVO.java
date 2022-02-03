package com.yh.libraryapp.book.model.vo;

public class BookListVO {
	private String book_name;
	private String authors;
	private String pub_com;
	private int pub_year;
	
	public BookListVO(String book_name, String authors, String pub_com, int pub_year) {
		this.book_name = book_name;
		this.authors = authors;
		this.pub_com = pub_com;
		this.pub_year = pub_year;
	}
	
	public String getBook_name() {
		return book_name;
	}
	public String getAuthors() {
		return authors;
	}
	public String getPub_com() {
		return pub_com;
	}
	public int getPub_year() {
		return pub_year;
	}
	
}
