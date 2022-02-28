package com.yh.libraryapp.book.model.vo.type;

public enum LoanYNType {
	대출가능("YES"),
	대출중("NO");

	
	private String value;
	LoanYNType(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public static LoanYNType lookup(String parameter) {
		for(LoanYNType item : LoanYNType.values())
		{
			if(item.getValue().equals(parameter))
			{
				return item;
			}
		}
		return null;
	}
}
