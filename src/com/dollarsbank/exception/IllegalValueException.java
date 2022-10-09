package com.dollarsbank.exception;

public class IllegalValueException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2887316918564967323L;

	public IllegalValueException() {
		System.err.println("+===================================================================+");
		System.err.println("|          Your withdrawal amount is more than your balance         |");
		System.err.println("+===================================================================+");
	}
}
