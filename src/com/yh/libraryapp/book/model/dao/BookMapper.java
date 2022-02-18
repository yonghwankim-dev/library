package com.yh.libraryapp.book.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

import com.yh.libraryapp.book.model.vo.BookVO;

public interface BookMapper {
	@Select("select * from all_book_vw")
	List<BookVO> findAllBook();
	
	@Select("select * from filter_book_vw where lib_name=#{lib_name}")
	List<BookVO> findByLibName(String lib_name);

	List<BookVO> findByContent(String content);
}

