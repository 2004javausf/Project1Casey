package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		boolean resp=false;
		ObjectMapper om = new ObjectMapper();
		Authentication authenticate = om.readValue(request.getInputStream(), Authentication.class);
		
		
		try {
			String username = authenticate.getUsername();
			String password = authenticate.getPassword();
			System.out.println(username);
			System.out.println(password);
			
			if(password.equals("admin123")) {
				resp=true;
				out.print(resp);
				HttpSession session= request.getSession();
				session.setAttribute("name",username);
				//response.sendRedirect("home");
				//request.getRequestDispatcher("home.html").forward(request, response);
			}else {
				out.print(resp);
			}
			
		}catch(NullPointerException e) {
			out.print(resp);
		}
		
		out.close();
		//response.sendRedirect("home");
		//request.getRequestDispatcher("home.html").forward(request, response);
	}

}
