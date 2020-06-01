package com.reimbursement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reimbursement.beans.Authentication;
import com.reimbursement.util.ConnFactory;

public class AuthenticationDAOImpl {
	
	private static ConnFactory cf = ConnFactory.getInstance();
	
	public Authentication getAuthenticated(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM AUTHENTICATION WHERE USERNAME=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, username);
		ResultSet rs = p.executeQuery();
		Authentication auth=null;
		if (rs.next()) {
			auth = new Authentication(rs.getString(1), rs.getString(2), rs.getInt(3));
		}
		return auth;
	}
	
	public Authentication getPermissions(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM AUTHENTICATION WHERE USERNAME=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, username);
		ResultSet rs = p.executeQuery();
		Authentication auth=null;
		if (rs.next()) {
			auth = new Authentication(rs.getString(1), rs.getString(2), rs.getInt(3));
		}
		return auth;
	}

}
