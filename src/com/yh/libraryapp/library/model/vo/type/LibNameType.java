package com.yh.libraryapp.library.model.vo.type;

public enum LibNameType {
	충남대학교(1),
	목원대학교(2),
	우송대학교(3),
	배재대학교(4),
	한남대학교(5);

	private int value;
	LibNameType(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
