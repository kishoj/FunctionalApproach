package tailrecursion;

import java.math.BigDecimal;

public class Fibonacci {
	public static BigDecimal valueOf(final BigDecimal n) {
		return n.compareTo(BigDecimal.ONE) == 1 ? tailRecursiveLoop(BigDecimal.ZERO, BigDecimal.ONE, n)
				: n.equals(BigDecimal.ZERO) ? BigDecimal.ZERO : BigDecimal.ONE;
	}

	// tail recursive loop
	private static BigDecimal tailRecursiveLoop(final BigDecimal x, final BigDecimal y, final BigDecimal n) {
		return n == BigDecimal.ZERO ? x : tailRecursiveLoop(y, x.add(y), n.subtract(BigDecimal.ONE));
	}
}
