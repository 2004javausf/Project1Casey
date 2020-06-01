package com.reimbursement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Taken from lessons from Revature. Thank you.

public class ConnFactory {
	//Singleton Factory
	
	//private static instance of self
	private static ConnFactory cf =new ConnFactory();
	
	//private no args constructor
	private ConnFactory() {
		super();
	}
	
	//public static synchronized "getter" method
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	//Methods that do stuff
	//get a  Connection to DB
	public Connection getConnection() {
		
		String url= "jdbc:oracle:thin:@java2004usf.ccz98pen4exd.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user= "tuition";
		String password= "reimbursement";
		Connection conn =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
