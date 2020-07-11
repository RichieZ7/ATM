package factory;

import utility.ATM;
import utility.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public final class AccountFactory {
    public static final Map<Long, Account> accountMap = new HashMap<>();
    public static final Random rand = new Random();

    public static void verifyAccountCreation(Scanner keyboard) {
        System.out.print("Would you like to create an account? ");
        if (keyboard.nextLine().toLowerCase().startsWith("y")) {
            System.out.println("Your user number is " + (accountMap.size() + 1) + ", please remember this number.");

            long newUserAccountNumber = Long.parseLong((rand.nextInt(10) + 1) + String.valueOf(rand.nextInt(10000000)));
            while (accountMap.containsKey(newUserAccountNumber))
                newUserAccountNumber = Long.parseLong((rand.nextInt(10) + 1) + String.valueOf(rand.nextInt(10000000)));


            System.out.println("Your 8-digit account number is " + newUserAccountNumber + ".");
            int newUserAccountPassword = keyboard.nextInt();

            accountMap.put(newUserAccountNumber,new Account(0,newUserAccountPassword));
        }
    }
}
