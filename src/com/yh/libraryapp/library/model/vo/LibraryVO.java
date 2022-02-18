package com.yh.libraryapp.library.model.vo;



public class LibraryVO {
	private int lib_regi_num;
	private String lib_name;
		
	public LibraryVO() {
		
	}

	public LibraryVO(Builder builder) {
		this.lib_regi_num = builder.lib_regi_num;
		this.lib_name = builder.lib_name;
	}
	
	static class Builder{
		private int lib_regi_num;
		private String lib_name;
		
		public Builder(int lib_regi_num) {
			this.lib_regi_num = lib_regi_num;
		}
		
		public Builder lib_name(String lib_name) {
			this.lib_name = lib_name;
			return this;
		}
		
		public LibraryVO build() {
			return new LibraryVO(this);
		}
	}

	public int getLib_regi_num() {
		return lib_regi_num;
	}

	public String getLib_name() {
		return lib_name;
	}

	@Override
	public String toString() {
		return "LibraryVO [lib_regi_num=" + lib_regi_num + ", lib_name=" + lib_name + "]";
	}	
}
