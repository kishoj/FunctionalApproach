package patterns.currying;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class MainApp {
	public static final int add(final int a, final int b) {
		return a + b;
	}

	public static Function<Integer, Function<Integer, Integer>> add() {
		return x -> y -> x + y;
	}

	public static Function<Integer, Function<Integer, Integer>> add2() {
		return new Function<Integer, Function<Integer, Integer>>() {
			@Override
			public Function<Integer, Integer> apply(final Integer x) {
				return new Function<Integer, Integer>() {
					@Override
					public Integer apply(Integer y) {
						return x + y;
					}
				};
			}
		};
	}

	public String four(Integer a, Integer b, String name, String postfix) {
		return name + (a * b) + postfix;
	}

	public static void main(String[] args) {
		System.out.println("Simple addition");
		System.out.println(add(1, 2));
		System.out.println("curried (level 2) addition of level 0");
		System.out.println(add());
		System.out.println("curried (level 2) addition of level 1, argments: 1");
		System.out.println(add().apply(1));
		System.out.println("curried (level 2) addition of level 2, argments: 1, 2");
		System.out.println(add().apply(1).apply(2));
		
		System.out.println("curried (level 2) addition2 of level 2, argments: 1, 2");
		System.out.println(add2().apply(1).apply(2));

		IntBinaryOperator simpleAdd = (a, b) -> a + b;
		IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;
		IntFunction<IntUnaryOperator> curriedMultiplication = a -> b -> a * b;
		
		System.out.println("Simple addition");
		System.out.println(simpleAdd.applyAsInt(10, 2));
		
		System.out.println("Curried addition");
		System.out.println(curriedAdd.apply(10).applyAsInt(2));
		
		System.out.println("Curried multiplication");
		System.out.println(curriedMultiplication.apply(10).applyAsInt(2));
	}
}
