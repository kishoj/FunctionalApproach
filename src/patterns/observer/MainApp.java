package patterns.observer;

import java.math.BigDecimal;
import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) {
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		Consolidator c = new Consolidator(Arrays.asList(a, b));

		System.out.println("Total Balance " + c.getTotalBalance());
		a.deposit(BigDecimal.valueOf(20));
		System.out.println("Total Balance " + c.getTotalBalance());
		b.deposit(BigDecimal.valueOf(30));
		System.out.println("Total Balance " + c.getTotalBalance());
	}

}
