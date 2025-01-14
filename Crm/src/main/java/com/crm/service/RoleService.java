package com.crm.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.dao.RoleDao;
import com.crm.model.Role;

public class RoleService {

	private static final Logger LOGGER = LogManager.getLogger(RoleService.class);

	public boolean updateRole(int id, String name, String des) {
		if (name != null && des != null && !name.isBlank() && !des.isBlank()) {
			return new RoleDao().updateRole(id, name, des);
		}
		LOGGER.warn("Invalid input provided for updating role. Name: '{}', Description: '{}'", name, des);
		return false;
	}

	public List<Role> getRoles() {
		return new RoleDao().getRoles();
	}

	public boolean addRole(String name, String des) {
		if (name != null && des != null && !name.isBlank() && !des.isBlank()) {
			return new RoleDao().addRole(name, des);
		}
		LOGGER.warn("Invalid input provided for adding role. Name: '{}', Description: '{}'", name, des);
		return false;
	}

}
