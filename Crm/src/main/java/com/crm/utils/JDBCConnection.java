package com.crm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCConnection {
	private static final Logger LOGGER = LogManager.getLogger(JDBCConnection.class);
	private static final String URL = "jdbc:mysql://localhost:3308/crm";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			LOGGER.info("Connecting to the database.");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			LOGGER.error("JDBC Driver not found.", e);
		} catch (SQLException e) {
			LOGGER.error("Database connection failed.", e);
		}
		return null;
	}
}
