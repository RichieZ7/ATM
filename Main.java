import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Account user1 = new Account(2000.50, 11223344, 1234);
		Account user2 = new Account(100, 12345678, 1010);
		Account user3 = new Account(1000000, 10101010, 7777);
		Random rand = new Random();
		ArrayList<Account> listOfAccounts = new ArrayList<Account>();
		listOfAccounts.add(user1);
		listOfAccounts.add(user2);
		listOfAccounts.add(user3);
		int newUserAccountNumber = 0;
		int newUserAccountPassword = 0;
		double startingBalance = 0;
		
		System.out.print("Would you like to create an account? ");
		String yesOrNo = keyboard.nextLine();
		
		if (yesOrNo.toLowerCase().equals("yes")) {
			System.out.println("Your user number is " + (listOfAccounts.size()+1) + ", please remember this number.");
			newUserAccountNumber = Integer.parseInt(String.valueOf(rand.nextInt(10)+1) + String.valueOf(rand.nextInt(10000000)));
			System.out.println("Your 8-digit account number is " + newUserAccountNumber + ".");
			System.out.print("Please create your 4-digit password: ");
			newUserAccountPassword = keyboard.nextInt();
		}
		
		Account newUser = new Account(startingBalance, newUserAccountNumber, newUserAccountPassword);
		listOfAccounts.add(newUser);
		
		if (newUserAccountNumber == 0) {
			listOfAccounts.remove(newUser);
		}
		
		ATM.getTime();
		System.out.print("Please input your user number: ");
		int userNumber = keyboard.nextInt();
		ATM.askForAccountNumber(listOfAccounts.get(userNumber-1));
		ATM.askForAccountPassword(listOfAccounts.get(userNumber-1));
		ATM.giveUserOptions(listOfAccounts.get(userNumber-1));
		keyboard.close();
	}
	
}
