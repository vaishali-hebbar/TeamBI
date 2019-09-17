package com.sony.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateClassMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			connection = DriverManager.getConnection("jdbc:oracle:thin:@INSISCILT-4047:1521:XE", "Vaishali", "ykheb");

			
			  preparedStatement = connection.prepareStatement(
			 "delete  from login where userid='ram' ");
			  
			  int x = preparedStatement.executeUpdate(); 
			  if (x > 0) {
			  connection.commit(); System.out.println("deleted"); }
			 

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();

				}
				if (connection != null && !connection.isClosed()) {

					connection.close();

				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
