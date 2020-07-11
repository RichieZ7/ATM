import java.util.Scanner;
import java.util.Date;

public class ATM {
	
	static int userInputAccountNumber;
	static int userInputPassword;
	
	static Scanner keyboard = new Scanner(System.in);
	static Date date = new Date();
	
	public static void getTime() {
		System.out.println("Time: " + date);
	}
	
	public static void askForAccountNumber(Account user) {
		System.out.print("Please enter your account number to continue: ");
		userInputAccountNumber = keyboard.nextInt();
		if (userInputAccountNumber != user.getAccountNumber() ) {
			tryAgain(user.getAccountNumber(), 5);
		}
	}	
	
	public static void askForAccountPassword(Account user) {
		System.out.print("Please enter your account password to continue: ");
		userInputPassword = keyboard.nextInt();
		if (userInputPassword != user.getAccountPassword()) {
			tryAgain(user.getAccountPassword(), 3);
		}
	}
	
	public static void tryAgain(int actualInput, int numberOfTries) {
		for (int i = 2 ; i <= numberOfTries ; i++) {
			System.out.println("Sorry that was incorrect, please try again.");
			System.out.print("Attempt " + i + ": ");
			int attempt = keyboard.nextInt();
			if (attempt == actualInput) {
				return;
			}
		}
		System.out.println("Sorry! Too many incorrect attempts!");
		System.exit(0);
	}
	
	public static void giveUserOptions(Account user) {
		boolean userIsFinished = false;
		while(userIsFinished == false) {
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
				userIsFinished = true;
				System.out.println("Have a good day!");
			}
		}
	}
	
}