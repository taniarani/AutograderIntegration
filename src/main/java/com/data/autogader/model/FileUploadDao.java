package com.data.autogader.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileUploadDao {

	private static final String url = "jdbc:mysql://localhost:3306/autograder?useSSL=false";
	private static final String user = "root";
	private static final String password = "ankit";

	private static final String sql = "INSERT INTO users (first_name, last_name, photo) values (?, ?, ?)";

	public static int uploadFile(String firstName, String lastName, InputStream file) {
		int row = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url, user, password);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			if (file != null) {
				// fetches input stream of the upload file for the blob column
				preparedStatement.setBlob(3, file);
			}

			// sends the statement to the database server
			row = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return row;
	}

	private static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
public static void main(String[] args) throws FileNotFoundException {
	 File initialFile = new File("src/main/resources/application.properties");
	    InputStream targetStream = new FileInputStream(initialFile);
	uploadFile("ankit","kourav", targetStream);

	
}	
}