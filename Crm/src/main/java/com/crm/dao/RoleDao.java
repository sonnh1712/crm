package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crm.utils.JDBCConnection;

public class RoleDao {

	public boolean addRole(String name, String des) throws SQLException {

		Connection con = JDBCConnection.getConnection();

		String sql = "insert into role(name,des) values(?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, des);

		return ps.executeUpdate() > 0;

	}

}
