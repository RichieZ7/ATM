package utility;


import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;

import static factory.AccountFactory.accountMap;

public class ATM {
	static int userInputPassword;
	
	static Scanner keyboard = new Scanner(System.in);
	static Date date = new Date();
	
	public static void getTime() {
		System.out.println("Time: " + date);
	}

	public static Account logIn(){
		long accNumber = askForAccountNumber();
		for (Map.Entry<Long,Account> m: accountMap.entrySet()){
			if (m.getKey() == accNumber) {
				if (askForAccountPassword(m.getValue()) == null) {
					System.out.println("You have been locked out.");
					return null;
				}

				System.out.println("You are logged in!");
				return m.getValue().unlock();
			}

		}
		System.out.println("We were unable to identify you.");
		return null;
	}
	
	public static int askForAccountNumber() {
		System.out.println("Please enter your account number to continue: ");
		return keyboard.nextInt();
	}


	public static Integer askForAccountPassword(Account user) {
		System.out.print("Please enter your account password to continue: ");
		userInputPassword = keyboard.nextInt();
		if (userInputPassword != user.getAccountPassword()) {
			if (tryAgain(user.getAccountPassword(), 3))
				return user.getAccountPassword();
		} return null;
	}


	public static boolean tryAgain(int actualInput, int numberOfTries) {
		for (int i = 2 ; i <= numberOfTries ; i++) {
			System.out.println("Sorry that was incorrect, please try again.");
			System.out.print("Attempt " + i + ": ");
			int attempt = keyboard.nextInt();
			if (attempt == actualInput) {
				return true;
			}
		}
		System.out.println("Sorry! Too many incorrect attempts!");
		return false;
	}
	
	public static void giveUserOptions(Account user) {

		while(user.getStatus()) {
			System.out.println("Options: \n1.Check Balance\n2.Deposit\n3.Withdraw\n4.Quit");
			System.out.print("> ");
			int userChoice = keyboard.nextInt();
			if (userChoice == 1) {
				user.checkBalance();
			}
			else if (userChoice == 2) {
				user.deposit();
			}
			else if (userChoice == 3) {
				user.withdraw();
			}
			else if (userChoice == 4) {
				user.lock();
				System.out.println("Have a good day!");
			}
		}


	}
	
}