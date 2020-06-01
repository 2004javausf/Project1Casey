package com.reimbursement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.reimbursement.beans.Authentication;
import com.reimbursement.beans.Requests;
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

	public ArrayList<Requests> getSubordinates(Authentication auth) throws SQLException {
		Connection conn = cf.getConnection();
		Connection conn2 =cf.getConnection();
		String sql = "SELECT * FROM SUPERVISOR WHERE SUPERVISOR=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, auth.getUsername());
		ResultSet rs = p.executeQuery();
		Requests temp;
		ArrayList<Requests> rtn = new ArrayList<Requests>();
		while(rs.next()) {
			String sql2 = "SELECT * FROM REQUESTS WHERE USERNAME=? AND PEND_STATE=0";
			PreparedStatement p2 = conn2.prepareStatement(sql2);
			p2.setString(1,  rs.getString(1));
			ResultSet rs2 = p2.executeQuery();
			while (rs2.next()) {
				temp= new Requests(rs2.getInt(1),rs2.getString(2),rs2.getDouble(3),rs2.getInt(4),rs2.getInt(5));
				rtn.add(temp);
			}
		}
		return rtn;
	}

}
