package com.dollarsbank.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

import com.dollarsbank.exception.IllegalValueException;
import com.dollarsbank.extra.Animate;
import com.dollarsbank.model.Transactions;
import com.dollarsbank.model.Transactions.TransactionType;
import com.dollarsbank.model.User;

public class Login {
	public static boolean isLoggedIn = false;
	public static User loggedUser = null;
	public static List<User> users = new LinkedList<>();
	public static List<Transactions> transactionRecords = new ArrayList<>();

	public static final String BLUE = "\033[0;34m";
	public static final String WHITE_BACKGROUND = "\033[47m";
	public static final String RESET = "\033[0m";
	public static final String BLACK = "\033[0;30m";
	public static final String GREEN = "\033[0;32m";
	public static final String RED = "\033[0;31m";
	public static final String GREEN_BOLD = "\033[1;32m";

	public void displayMenu(Scanner scan) throws IllegalValueException {

		while (isLoggedIn == false) {

			while (isLoggedIn == false) {
				int choice = 0;

				System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
				System.out.println("|    DollarsBank Welcomes You!!    |");
				System.out.println("+==================================+" + RESET);
				System.out.printf("|    %-30s|%n", "1. Create New Account");
				System.out.printf("|    %-30s|%n", "2. Log In");
				System.out.printf("|    %-30s|%n", "3. Exit");
				System.out.println("+==================================+");

				System.out.println("Enter choice [1, 2 or 3] ");

				choice = scan.nextInt();

				switch (choice) {
				case 1:
					createNewUser(scan);
					break;
				case 2:
					login(scan);
					break;
				case 3:
					return;

				}

			}

			while (isLoggedIn == true && loggedUser != null) {
				int choice = 0;

				System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
				System.out.println("|              welcome             |");
				System.out.println("+==================================+" + RESET);
				System.out.printf("|    %-30s|%n", "1. Deposit Amount");
				System.out.printf("|    %-30s|%n", "2. Withdraw Amount");
				System.out.printf("|    %-30s|%n", "3. Funds Transfer");
				System.out.printf("|    %-30s|%n", "4. View 5 Recent Transactions");
				System.out.printf("|    %-30s|%n", "5. Display Customer Info");
				System.out.printf("|    %-30s|%n", "6. Logout");
				System.out.println("+==================================+");

				choice = scan.nextInt();

				switch (choice) {
				case 1:
					depositAmount(scan);
					break;
				case 2:
					withDrawAmount(scan);
					break;
				case 3:
				case 4:
					recentTransactions();
					break;
				case 5:
					displayInfo();
					break;
				case 6:
					loggedUser = null;
					isLoggedIn = false;
					break;

				}

			}
		}
	}

	private void createNewUser(Scanner scan) {
		String name = null, address = null, contact = null, password = null, id = null;
		double deposit = 0;

		System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
		System.out.println("|   Enter Details for New Account  |");
		System.out.println("+==================================+" + RESET);

		try {
//			System.out.printf("%-24s", "Full Name: ");
//			scan.nextLine();
//			name = scan.nextLine();
//
//			if (!name.matches("^[a-zA-Z]*$")) {
//				throw new Exception();
//			}
//
//			System.out.printf("%-24s", "Address: ");
//			address = scan.nextLine();
//
//			System.out.printf("%-24s", "Contact Number: ");
//			contact = scan.nextLine();
//
//			if (!contact.matches("^[0-9]{10}$")) {
//				throw new Exception("Numeric values only");
//			}
//
//			System.out.printf("%-24s", "User ID: ");
//			id = scan.nextLine();
//			
//			for(User u : users) {
//				if(u.getId().equals(id)) {
//					throw new Exception("User ID exists. Select another user ID!");
//				}
//			}
//
//			System.out.printf("%-24s", "Password: ");
//			System.out.println("8 Characters with Lower, Upper & a Special Character");
//			password = scan.nextLine();
//
//			System.out.printf("%-24s", "Initial Deposit Amount: $");
//			deposit = scan.nextDouble();

//			User user = new User(id, name, address, password, contact, deposit);

			User user1 = new User("AB001", "Zainal Shariff", "70000 East Park, Sacramento, CA 95822", "password",
					"9163019569", 500.00);
			User user2 = new User("AB002", "Zinu Shariff", "70001 Elk Grove, Sacramento, CA 95826", "password",
					"9163019566", 600.00);


			Date date = Date.valueOf(LocalDate.now());

//			Transactions transact = new Transactions(user.getId(), deposit, date, TransactionType.INITIAL_DEPOSIT);
//			transactionRecords.add(transact);

			Transactions transact1 = new Transactions(user1.getId(), 500, date, TransactionType.INITIAL_DEPOSIT);
			Transactions transact2 = new Transactions(user2.getId(), 600, date, TransactionType.INITIAL_DEPOSIT);
			transactionRecords.add(transact1);
			transactionRecords.add(transact2);


			try {
				users.add(user1);
				users.add(user2);

//				users.add(user);

				Animate.load();
				System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
				System.out.println("|    User created successfully!    |");
				System.out.println("+==================================+" + RESET);

			} catch (Exception e) {

				Animate.load();
				System.err.println(BLUE + WHITE_BACKGROUND + "+==================================+");
				System.err.println("|     User could not be created    |");
				System.err.println("+==================================+" + RESET);

			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void login(Scanner scan) {
		String id = null, password = null;

		System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
		System.out.println("|              Log In              |");
		System.out.println("+==================================+" + RESET);
		System.out.print("User ID: ");
		scan.nextLine();
		id = scan.nextLine();

		System.out.print("Password: ");
		password = scan.nextLine();

		for (User u : users) {
			if (u.getId().equals(id)) {
				if (u.getPassword().equals(password)) {
					loggedUser = u;
					isLoggedIn = true;
					Animate.load();
					System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
					System.out.println("|      Successfully Logged In      |");
					System.out.println("+==================================+" + RESET);
					break;
				} else {
					System.err.println(BLUE + WHITE_BACKGROUND + "+==================================+");
					System.err.println("|        Incorrect Password        |");
					System.err.println("+==================================+" + RESET);
				}
			}
		}
	}

	private void depositAmount(Scanner scan) {
		double deposit = 0;

		System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
		System.out.println("|              Deposit             |");
		System.out.println("+==================================+" + RESET);

		scan.nextLine();
		System.out.print("Enter amount: $");
		deposit = scan.nextDouble();

		Date date = Date.valueOf(LocalDate.now());

		Transactions transact = new Transactions(loggedUser.getId(), deposit, date, TransactionType.DEPOSIT);
		transactionRecords.add(transact);

		for (User u : users) {
			if (u.getId().equals(loggedUser.getId())) {
				double bal = u.getBalance();
				bal = bal + deposit;
				u.setBalance(bal);
				loggedUser.setBalance(bal);
			}
		}

	}

	private void withDrawAmount(Scanner scan) throws IllegalValueException {
		double withdraw = 0;

		System.out.println(BLUE + WHITE_BACKGROUND + "+==================================+");
		System.out.println("|             Withdraw             |");
		System.out.println("+==================================+" + RESET);

		scan.nextLine();
		System.out.print("Enter amount: $");
		withdraw = scan.nextDouble();

		try {
			if (withdraw > loggedUser.getBalance()) {
				throw new IllegalValueException();
			} else {

				Date date = Date.valueOf(LocalDate.now());

				Transactions transact = new Transactions(loggedUser.getId(), withdraw, date,
						TransactionType.WITHDRAWAL);
				transactionRecords.add(transact);

				for (User u : users) {
					if (u.getId().equals(loggedUser.getId())) {
						double bal = u.getBalance();
						bal = bal - withdraw;
						u.setBalance(bal);
						loggedUser.setBalance(bal);
					}
				}
			}

		} catch (Exception e) {

		}

	}

	List<Transactions> select = new ArrayList<>();

	private void recentTransactions() {
		for (Transactions t : transactionRecords) {
			if (t.getUser_id().equals(loggedUser.getId())) {
				select.add(t);
			}
		}

		Collections.reverse(select);

		System.out.println(
				BLUE + WHITE_BACKGROUND + "+===================================================================+");
		System.out.println("|                      Recent Transactions                          |");
		System.out.println("+===================================================================+" + RESET);

		if (select.size() == 0) {
			System.out.println("No Records Found");
		} else if (select.size() < 5) {

			for (int i = 0; i < select.size(); i++) {

				SimpleDateFormat sd = new SimpleDateFormat("E MMMM dd HH:mm:ss z YYYY");
				sd.setTimeZone(TimeZone.getTimeZone("IST"));

				System.out.printf("|%-15s - $%.2f as on %s%n", select.get(i).getType().toString(),
						select.get(i).getValue(), sd.format(select.get(i).getDate()));
			}

		} else {
			for (int i = 0; i < select.size(); i++) {

				SimpleDateFormat sd = new SimpleDateFormat("E MMMM dd HH:mm:ss z YYYY");
				sd.setTimeZone(TimeZone.getTimeZone("IST"));

				System.out.printf("|%-15s - $%.2f as on %s%n", select.get(i).getType().toString(),
						select.get(i).getValue(), sd.format(select.get(i).getDate()));
			}

		}
		System.out.println("+===================================================================+");

		select.clear();
	}

	private void displayInfo() {

		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMMM yyyy");
		String formattedString = localDate.format(formatter);

		System.out.println(
				BLUE + WHITE_BACKGROUND + "+================================================================+");
		System.out.println("|                         Customer Info                          |");
		System.out.println("+================================================================+" + RESET);
		System.out.printf("| %s %-15s %33s%n", loggedUser.getId(), " ", formattedString);
		System.out.printf("| %-33s %33s%n", loggedUser.getName(), " ");
		System.out.printf("| %-33s %-15s $%.2f%n", loggedUser.getAddress(), " ", loggedUser.getBalance());
		System.out.println("+================================================================+");
	}

}
