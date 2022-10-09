package com.dollarsbank.model;

import java.util.Date;

public class Transactions {

	public enum TransactionType {
		INITIAL_DEPOSIT,WITHDRAWAL, DEPOSIT;
	}

	private String user_id;
	private double value;
	private Date date;
	private TransactionType type;

	public Transactions() {

	}

	public Transactions(String user_id, double value, Date date, TransactionType type) {
		super();
		this.user_id = user_id;
		this.value = value;
		this.date = date;
		this.type = type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transactions [user_id=" + user_id + ", value=" + value + ", date=" + date + ", type=" + type + "]";
	}

}
