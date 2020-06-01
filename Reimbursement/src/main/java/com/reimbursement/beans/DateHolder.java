package com.reimbursement.beans;

public class DateHolder {
	
	private int date;
	
	

	public DateHolder() {
		super();
	}

	public DateHolder(int date) {
		super();
		this.date = date;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DateHolder [date=" + date + "]";
	}

}
