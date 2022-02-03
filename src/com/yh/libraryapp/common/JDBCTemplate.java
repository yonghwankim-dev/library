package com.yh.libraryapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
	public static final String USER = "LIBRARY";
	public static final String PWD = "LIBRARY";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PWD);
	}
}
