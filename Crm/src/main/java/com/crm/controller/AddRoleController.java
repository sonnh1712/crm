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

	private static final Logger logger = LogManager.getLogger(AddRoleController.class);
	private final RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/view/add-role.jsp").include(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String des = req.getParameter("des");

		logger.info("Request /add-role name = {} - des = {}", name, des);

		try {
			String message = roleService.addRole(name, des) ? "Thêm role thành công" : "Thêm role thất bại";
			req.setAttribute("message", message);
			logger.info("Request /add-role {}", message.contains("thành công") ? "success" : "fail");
		} catch (SQLException e) {
			req.setAttribute("message", "Tên role đã tồn tại");
			logger.error("Error occurred while processing request /add-role", e);
		}

		req.getRequestDispatcher("/view/add-role.jsp").include(req, resp);

	}

}
