import java.util.Scanner;

public class Account {
	
	private double balance;
	private int accountNumber;
	private int accountPassword;
	
	Scanner scanner = new Scanner(System.in);
	
	
	public Account(double userBalance, int userAccountNumber, int userAccountPassword) {
		balance = userBalance;
		accountNumber = userAccountNumber;
		accountPassword = userAccountPassword;
	}
	
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setAccountNumber(int newAccountNumber) {
		accountNumber = newAccountNumber;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountPassword(int newAccountPassword) {
		accountPassword = newAccountPassword;
	}
	
	public int getAccountPassword() {
		return accountPassword;
	}
	
	public void checkBalance() {
		System.out.println("Balance: $" + balance);
	}
	
	public void deposit() {
		System.out.print("Deposit Amount: $");
		double userDeposit = scanner.nextDouble();
		while (userDeposit < 0 ) {
			System.out.println("Invalid Amount!");
			System.out.print("Deposit Amount: $");
			userDeposit = scanner.nextDouble();
		}
		balance += userDeposit;
		System.out.println("You have deposited $" + userDeposit);
	}
	
	public void withdraw() {
		System.out.print("Withdraw Amount: $");
		double userWithdraw = scanner.nextDouble();
		while (userWithdraw < 0 || userWithdraw > balance) {
			System.out.println("Invalid Amount!");
			System.out.print("Withdraw Amount: $");
			userWithdraw = scanner.nextDouble();
		}
		balance -= userWithdraw;
		System.out.println("You have withdrawn $" + userWithdraw);
	}
	
}
