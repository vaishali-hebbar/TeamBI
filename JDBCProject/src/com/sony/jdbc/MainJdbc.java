package com.sony.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sony.jdbc.TryClass;

public class MainJdbc {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		TryClass ob=new TryClass();

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			connection = DriverManager.getConnection("jdbc:oracle:thin:@INSISCILT-4047:1521:XE", "Vaishali", "ykheb");

			/*
			 * preparedStatement = connection.prepareStatement(
			 * "insert into login values(?,?,?)");
			 * 
			 * preparedStatement.setString(1, "Suma Ai");
			 * preparedStatement.setString(2, "8888");
			 * preparedStatement.setString(3, "Y"); int x =
			 * preparedStatement.executeUpdate(); if (x > 0) {
			 * connection.commit(); System.out.println("Inserted"); }
			 */


			preparedStatement = connection.prepareStatement("select *     from login ");

			resulSet = preparedStatement.executeQuery();
			while (resulSet.next()) {
				System.out.println(resulSet.getString(1) + " " + resulSet.getString(2) + " " + resulSet.getString(3));
			}

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
				if (resulSet != null && !resulSet.isClosed()) {

					resulSet.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}