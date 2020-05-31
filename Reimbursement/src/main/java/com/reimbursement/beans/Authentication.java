package com.reimbursement.beans;

public class Authentication {
	
	private int id;
	private String username;
	private String password;
	
	public Authentication(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Authentication(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Authentication() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Authentication [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	

}