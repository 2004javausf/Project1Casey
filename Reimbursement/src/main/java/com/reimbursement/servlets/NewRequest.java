package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.beans.Requests;
import com.reimbursement.daoimpl.RequestsDAOImpl;

public class NewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NewRequest() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		Requests newRequest = om.readValue(request.getInputStream(), Requests.class);
		RequestsDAOImpl ri = new RequestsDAOImpl();
		boolean overdrafted;
		boolean overdue;
		try {
			overdrafted = ri.isOverdrafted(newRequest);
			overdue = ri.isOverdue(newRequest);
			System.out.println(overdrafted);
			System.out.println(overdue);
			String tmp="";
			tmp += om.writeValueAsString(overdrafted);
			tmp += om.writeValueAsString(overdue);
			if(!overdrafted && !overdue) {
				ri.write(newRequest);
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(tmp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
