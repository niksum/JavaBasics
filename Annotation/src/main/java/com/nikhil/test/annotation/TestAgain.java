package com.nikhil.test.annotation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAgain {
	public static void main(String[] args) {
		Connection con = null;
		Connection con1 = null;
		Statement stm = null;
		Statement stm1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "nik_test_user", "4444");
			stm = con.createStatement();
			rs = stm.executeQuery("select * from dual");
			while (rs.next())
				System.out.println("Result " + rs.getString(1));

			//////////// Anotherway to load Driver
			System.out.println("Another way");
			
			Driver driver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(driver);
			con1 = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "nik_test_user", "4444");
			stm1 = con1.createStatement();
			rs1 = stm1.executeQuery("select * from dual");
			while (rs1.next())
				System.out.println("Result " + rs1.getString(1));

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
				con.close();
				stm1.close();
				con1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
