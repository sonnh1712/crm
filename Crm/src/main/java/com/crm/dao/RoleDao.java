package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.model.Role;
import com.crm.utils.JDBCConnection;

public class RoleDao {

	private static final Logger LOGGER = LogManager.getLogger(RoleDao.class);

	public boolean updateRole(int id, String name, String des) {
		Connection con = JDBCConnection.getConnection();
		if (con == null) {
			return false;
		}
		LOGGER.info("Attempting to update role with ID: {}, name: {}, description: {}", id, name, des);
		String sql = "UPDATE role SET name=?, des=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, des);
			ps.setInt(3, id);
			int result = ps.executeUpdate();
			LOGGER.info("Role updated successfully, rows affected: {}", result);
			return result > 0;
		} catch (Exception e) {
			LOGGER.error("Error updating role in the database.", e);
			return false;
		}
	}

	public List<Role> getRoles() {
		List<Role> list = new ArrayList<Role>();
		Connection con = JDBCConnection.getConnection();
		if (con == null) {
			return null;
		}
		LOGGER.info("Database connection established, executing query to fetch roles.");
		String sql = "SELECT * FROM role";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Role(rs.getInt("id"), rs.getString("name"), rs.getString("des")));
			}
			if (list.isEmpty()) {
				LOGGER.warn("No roles found.");
				return null;
			}
			LOGGER.info("Roles fetched successfully, returning {} roles.", list.size());
			return list;
		} catch (SQLException e) {
			LOGGER.error("Error fetching roles from the database.", e);
			return null;
		}
	}

	public boolean addRole(String name, String des) {
		Connection con = JDBCConnection.getConnection();
		if (con == null) {
			return false;
		}
		LOGGER.info("Attempting to add role with name: {} and description: {}", name, des);
		String sql = "INSERT INTO role(name, des) VALUES(?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, des);
			int result = ps.executeUpdate();
			LOGGER.info("Role added, rows affected: {}", result);
			return result > 0;
		} catch (Exception e) {
			LOGGER.error("Error adding role to database.", e);
			return false;
		}
	}

}
