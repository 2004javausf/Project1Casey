package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.beans.Authentication;
import com.reimbursement.beans.Requests;
import com.reimbursement.daoimpl.AuthenticationDAOImpl;


public class GetSupervisorTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		Authentication auth = om.readValue(request.getInputStream(), Authentication.class);
		AuthenticationDAOImpl ai = new AuthenticationDAOImpl();
		ArrayList<Requests> rtn = new ArrayList<Requests>();
		try {
			rtn=ai.getSubordinates(auth);
			String json = om.writeValueAsString(rtn);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
