
import factory.AccountFactory;
import utility.ATM;
import utility.Account;

import java.util.*;
import static factory.AccountFactory.*;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		accountMap.putIfAbsent(11223344L, new Account(2000.50, 1234));
		accountMap.putIfAbsent(12345678L, new Account(100, 1010));
		accountMap.putIfAbsent(10101010L, new Account(1000000, 7777));

		AccountFactory.verifyAccountCreation(keyboard);
		Account a = ATM.logIn();
		if (a != null)
			a.checkBalance();

		
		ATM.getTime();
		keyboard.close();
	}
	
}
