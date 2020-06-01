package com.reimbursement.beans;

public class Authentication {
	
	private String username;
	private String password;
	private int accountType;
	
	public Authentication(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Authentication(String username, String password, int accountType) {
		super();
		this.accountType = accountType;
		this.username = username;
		this.password = password;
	}
	public Authentication() {
		super();
	}
	public int getAccountType() {
		return accountType;
	}
	public void setId(int accountType) {
		this.accountType = accountType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Authentication [accountType=" + accountType + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
