package com.reimbursement.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reimbursement.beans.DateHolder;
import com.reimbursement.util.ConnFactory;

public class DateHolderDAOImpl {

	private static ConnFactory cf = ConnFactory.getInstance();
	
	public DateHolder getDate() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CURRENT_DATE";
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		DateHolder dh = new DateHolder();
		rs.next();
			dh = new DateHolder(rs.getInt(1));

		return dh;
	}
	
	public void setDate(DateHolder dh) throws SQLException {
		Connection conn = cf.getConnection();
		System.out.println("At update statement");
		String sql = "{ call DELETE FROM CURRENT_DATE; INSERT INTO CURRENT_DATE VALUES(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, dh.getDate());
		call.execute();
		
		
		//update table urgencies
	}
	
}
