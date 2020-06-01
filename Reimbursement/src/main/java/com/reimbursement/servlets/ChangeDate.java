package com.reimbursement.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.beans.DateHolder;
import com.reimbursement.daoimpl.DateHolderDAOImpl;

public class ChangeDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeDate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost of ChangeDate");
		ObjectMapper om = new ObjectMapper();
		DateHolder date = om.readValue(request.getInputStream(), DateHolder.class);
		System.out.println(date.getDate());
		DateHolderDAOImpl dh = new DateHolderDAOImpl();
		
		try {
			dh.setDate(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
