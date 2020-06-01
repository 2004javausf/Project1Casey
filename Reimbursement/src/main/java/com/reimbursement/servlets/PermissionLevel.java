package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.beans.Authentication;
import com.reimbursement.daoimpl.AuthenticationDAOImpl;


public class PermissionLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = new PrintWriter(response.getWriter());
		Authentication auth = om.readValue(request.getInputStream(), Authentication.class);
		AuthenticationDAOImpl ad= new AuthenticationDAOImpl();
		
		try {
			auth = ad.getPermissions(auth.getUsername());
			String temp;
			temp = om.writeValueAsString(auth.getAccountType());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
