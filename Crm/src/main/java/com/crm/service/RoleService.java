package com.crm.service;

import java.sql.SQLException;

import com.crm.dao.RoleDao;

public class RoleService {

	public boolean addRole(String name, String des) throws SQLException {

		if (name != null && des != null && !name.isBlank() && !des.isBlank()) {
			return new RoleDao().addRole(name, des);
		}

		return false;

	}

}
