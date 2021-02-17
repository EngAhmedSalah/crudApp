package com.luv2code.testdb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3307/web_customer_tracker?useSSL=false";
		String uname = "root", password = "root";
		Connection con = DriverManager.getConnection(dbUrl, uname, password);
		System.out.println(con);
	}
}