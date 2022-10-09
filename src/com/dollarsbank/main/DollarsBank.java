package com.dollarsbank.main;

import java.util.Scanner;

import com.dollarsbank.controller.Login;
import com.dollarsbank.exception.IllegalValueException;

public class DollarsBank {

	public static void main(String[] args) throws IllegalValueException{

		Scanner scan = new Scanner(System.in);
		Login login = new Login();
		
		login.displayMenu(scan);
		
	}

}
