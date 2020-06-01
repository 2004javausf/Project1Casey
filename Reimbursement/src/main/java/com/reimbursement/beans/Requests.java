package com.reimbursement.beans;

public class Requests {

	private int id;
	private String username;
	private double request;
	private int state;
	private int deadline;
	public Requests() {
		super();
	}
	
	
	public Requests(String username, double request, int state, int deadline) {
		super();
		this.username = username;
		this.request = request;
		this.state = state;
		this.deadline = deadline;
	}



	public Requests(int id, String username, double request, int state, int deadline) {
		super();
		this.id = id;
		this.username = username;
		this.request = request;
		this.state = state;
		this.deadline = deadline;
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
	public double getRequest() {
		return request;
	}
	public void setRequest(double request) {
		this.request = request;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "Requests [id=" + id + ", username=" + username + ", request=" + request + ", state=" + state
				+ ", deadline=" + deadline + "]";
	}
	
	
	
}
