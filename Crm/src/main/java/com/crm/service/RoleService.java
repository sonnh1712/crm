package com.crm.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.dao.RoleDao;

public class RoleService {

	private static final Logger LOGGER = LogManager.getLogger(RoleService.class);

	public boolean addRole(String name, String des) {
		if (name != null && des != null && !name.isBlank() && !des.isBlank()) {
			return new RoleDao().addRole(name, des);
		}
		LOGGER.warn("Invalid input: name={}, des={}", name, des);
		return false;
	}

}
