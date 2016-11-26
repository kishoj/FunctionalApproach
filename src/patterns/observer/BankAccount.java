package patterns.observer;

import java.math.BigDecimal;

public class BankAccount extends Publisher {
	private BigDecimal balance = BigDecimal.ZERO;
	
	public BigDecimal getCurrentBalance() {
		return balance;
	}

	public void deposit(BigDecimal amount) {
		if (amount.doubleValue() > 0) {
			balance = balance.add(amount);
			publish();
		}
	}
	
	public void withdraw(BigDecimal amount) throws Exception {
		 if (0 < amount.doubleValue() && amount.doubleValue() <= balance.doubleValue()) {
			 balance = balance.subtract(amount);
			 publish();
		} else throw new Exception("Insufficient Funds");
	}
}
