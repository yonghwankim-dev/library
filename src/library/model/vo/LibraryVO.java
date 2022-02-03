package library.model.vo;

public class LibraryVO {
	private int lib_regi_num;	// 도서관등록번호
	private String lib_name;	// 도서관이름
	
	public LibraryVO(int lib_regi_num, String lib_name) {
		this.lib_regi_num = lib_regi_num;
		this.lib_name = lib_name;
	}
	
	public int getLib_regi_num() {
		return lib_regi_num;
	}
	public String getLib_name() {
		return lib_name;
	}
	
	
}
