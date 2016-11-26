package patterns.functional.compositions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {
	public static int doWork(int value, Function<Integer, Integer> function) {
		return function.apply(value);
	}
	
	public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
		return values.stream().filter(selector).mapToInt(e -> e).sum();
		//return values.stream() .filter(selector) .reduce(0, Integer::sum);
		//return values.stream() .filter(selector) .reduce(0, (a, b) -> a + b);
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(numbers.stream().filter(Utils::isEven).map(Utils::doubleIt).collect(Collectors.toList()));
		numbers.forEach(System.out::println);

		System.out.println(totalValues(numbers, e -> true));
		System.out.println(totalValues(numbers, Utils::isEven));
		System.out.println(totalValues(numbers, Utils::isOdd));
		
		
		Function<Integer, Integer> inc = e -> e + 1;
		Function<Integer, Integer> doubleIt = e -> e * 2;

		System.out.println(doWork(5, inc));
		System.out.println(doWork(5, doubleIt));
		
		// Chaining functions together
		System.out.println(doWork(5, inc.andThen(doubleIt).andThen(inc)));
	}

}
