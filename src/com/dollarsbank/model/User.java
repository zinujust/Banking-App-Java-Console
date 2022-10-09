package com.dollarsbank.model;

import java.io.Serializable;

public class User implements Serializable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String address;
	private String password;
	private String contact;
	private double balance;

	public User() {
	}

	public User(String id, String name, String address, String password, String contact, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.password = password;
		this.contact = contact;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", password=" + password + ", contact="
				+ contact + ", balance=" + balance + "]";
	}

}
