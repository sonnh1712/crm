package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.utils.JDBCConnection;

public class RoleDao {

	private static final Logger LOGGER = LogManager.getLogger(RoleDao.class);

	public boolean addRole(String name, String des) {
		try (Connection con = JDBCConnection.getConnection()) {
			if (con == null) {
				LOGGER.error("Failed to obtain database connection.");
				return false;
			}

			String sql = "INSERT INTO role(name, des) VALUES(?, ?)";
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, name);
				ps.setString(2, des);
				int result = ps.executeUpdate();
				LOGGER.info("Role added, rows affected: {}", result);
				return result > 0;
			}
		} catch (SQLException e) {
			LOGGER.error("Error adding role to database.", e);
			return false;
		}
	}

}
