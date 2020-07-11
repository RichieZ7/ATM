package utility;

import java.util.Date;
import java.util.Scanner;

import static utility.ATM.keyboard;

public class Account implements Lockable<Account> {
	
	private double balance;
	private int accountPassword;
	private long dateOfCreation;
	private boolean unlocked = false;
	
	Scanner scanner = new Scanner(System.in);
	
	
	public Account(double userBalance, int userAccountPassword) {
		balance = userBalance;
		accountPassword = userAccountPassword;
		dateOfCreation = System.currentTimeMillis();
	}
	
	public void setBalance(double newBalance) {
		if (!unlocked) return; balance = newBalance;
	}
	
	public Double getBalance() {
		return unlocked ? balance : null;
	}
	
	public void setAccountPassword(int newAccountPassword) {
		System.out.println("Input your old password in first to verify your identity");
		if (keyboard.nextInt() != this.accountPassword)
			ATM.tryAgain(this.accountPassword,3);
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

	public long getDateOfCreation(){
		return this.dateOfCreation;
	}

	@Override
	public Account unlock() {
		unlocked = true;
		return this;
	}

	@Override
	public boolean getStatus() {
		return unlocked;
	}

	@Override
	public Account lock() {
		unlocked = false;
		return this;
	}
}
