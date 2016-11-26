package patterns.observer;

import java.math.BigDecimal;
import java.util.List;

public class Consolidator implements Subscriber {

	private List<BankAccount> observed;
	private BigDecimal totalBalance;

	public Consolidator(List<BankAccount> observed) {
		this.observed = observed;
		observed.forEach(observer -> observer.subscribe(this));
	}

	@Override
	public void handler(Publisher publisher) {
		compute();
	}

	private void compute() {
		totalBalance = observed.stream().map(BankAccount::getCurrentBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
		if (totalBalance == null)
			totalBalance = BigDecimal.ZERO;
	}

	public BigDecimal getTotalBalance() {
		if (totalBalance == null)
			totalBalance = BigDecimal.ZERO;
		return totalBalance;
	}
}