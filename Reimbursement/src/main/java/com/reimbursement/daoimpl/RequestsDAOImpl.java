package com.reimbursement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reimbursement.beans.DateHolder;
import com.reimbursement.beans.Requests;
import com.reimbursement.util.ConnFactory;

public class RequestsDAOImpl {
	
	private static ConnFactory cf = ConnFactory.getInstance();
	
	public boolean isOverdrafted(Requests re) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REQUESTS WHERE USERNAME=? AND PEND_STATE !=-1";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, re.getUsername());
		ResultSet rs = p.executeQuery();
		double total = re.getRequest();
		while(rs.next()) {
			total += rs.getInt(3);
		}
		if(total > 1000) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isOverdue(Requests re) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CURRENT_DATE";
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		rs.next();
		int today = rs.getInt(1);
		if (today + 7 <= re.getDeadline()) {
			return false;
		}else {
			return true;
		}
	}

	public void write(Requests newRequest) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO REQUESTS VALUES(ID_GEN.NEXTVAL,?,?,0,?)";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, newRequest.getUsername());
		p.setDouble(2, newRequest.getRequest());
		p.setInt(3, newRequest.getDeadline());
		p.execute();
	}
}
