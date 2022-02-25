package com.yh.libraryapp.book.model.vo;

public class DetailBookVO {
	private String book_name;
	private String author_name;
	private String pub_com;
	private int pub_year;
	private long isbn;

	public DetailBookVO() {
		
	}

	public DetailBookVO(String book_name, String author_name, String pub_com, int pub_year, long isbn) {
		this.book_name = book_name;
		this.author_name = author_name;
		this.pub_com = pub_com;
		this.pub_year = pub_year;
		this.isbn = isbn;
	}

	public String getBook_name() {
		return book_name;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public String getPub_com() {
		return pub_com;
	}

	public int getPub_year() {
		return pub_year;
	}

	public long getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return "DetailBookVO [book_name=" + book_name + ", author_name=" + author_name + ", pub_com=" + pub_com
				+ ", pub_year=" + pub_year + ", isbn=" + isbn + "]";
	}
}
