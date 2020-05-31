package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.beans.Authentication;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet of LoginServlet");
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost of LoginServlet");
		PrintWriter out= response.getWriter();
		ObjectMapper om = new ObjectMapper();
		Authentication authenticate = om.readValue(request.getInputStream(), Authentication.class);
		
		try {
			System.out.println(authenticate.getUsername());
			System.out.println(authenticate.getPassword());
			
			out.print(authenticate.getUsername()+authenticate.getPassword());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		/*
		if(password.equals("admin123")) {
			out.print("Welcome, "+ username);
			HttpSession session= request.getSession();
			session.setAttribute("name",username);
		}else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		*/
		out.close();
		//response.sendRedirect("home");
		//request.getRequestDispatcher("home.html").forward(request, response);
	}

}
