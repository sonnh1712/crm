package com.crm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.service.RoleService;

@WebServlet(urlPatterns = { "/add-role" })
public class AddRoleController extends HttpServlet {

	private static final Logger LOGGER = LogManager.getLogger(AddRoleController.class);
	private final RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("Handling GET request for /add-role");
		req.getRequestDispatcher("/view/add-role.jsp").forward(req, resp);
		LOGGER.info("Completed GET request for /add-role");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("Handling POST request for /add-role");

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String des = req.getParameter("des");

		LOGGER.info("POST /add-role parameters - name: {}, des: {}", name, des);

		String message = roleService.addRole(name, des) ? "Role added successfully" : "Failed to add role";
		req.setAttribute("message", message);

		LOGGER.info("POST /add-role result: {}", message);

		req.getRequestDispatcher("/view/add-role.jsp").forward(req, resp);
		LOGGER.info("Completed POST request for /add-role");
	}

}
