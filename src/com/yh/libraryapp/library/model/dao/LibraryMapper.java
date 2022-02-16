package com.yh.libraryapp.library.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.yh.libraryapp.library.model.vo.LibraryVO;

public interface LibraryMapper {
	
	@Select("select * from library")
	List<LibraryVO> findAllLibrary();
}
