package patterns.tailrecursion;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class MainApp {

	public static void main(String[] args) {
		// Fibonacci numbers from 0 to 10
		IntStream.range(0, 11).mapToObj(BigDecimal::valueOf).forEach(number -> {
			System.out.println("f(" + number + "):= " + Fibonacci.valueOf(number));
		});
	}
}
