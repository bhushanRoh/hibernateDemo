package com.bhus.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		
		String jdbcUrl= "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="bhushan";
		
		try {
			
			System.out.println("Connecting To DB: "+jdbcUrl);
			Connection myconn= DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection Successful !!!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
