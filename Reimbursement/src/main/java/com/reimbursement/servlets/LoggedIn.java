package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoggedIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost of LoginServlet");
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		boolean resp=false;
		request.getRequestDispatcher("index.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session != null) {
			resp=true;
			System.out.println("Session Exists");
		}
		else {
			System.out.println("Session does not exist");
		}
		
		out.print(resp);
	}

}
