package patterns.functional.inteface;

public class MainApp {

	public static void main(String[] args) {
		Operator<Integer> plus = (x, y) -> x + y;
		Operator<Integer> minus = (x, y) -> x - y;
		Operator<Integer> multiply = (x, y) -> x * y;
		Operator<Integer> divide = (x, y) -> x / y;
		
		System.out.println(plus.apply(2, 3));
		System.out.println(minus.apply(3, 2));
		System.out.println(multiply.apply(2, 5));
		System.out.println(divide.apply(10, 5));
		
		Double a = Double.valueOf(10.00);
		Double b = Double.valueOf(5.00);
		System.out.println(SimpleOperation.PLUS.apply(a, b));
		System.out.println(SimpleOperation.MINUS.apply(a, b));
		System.out.println(SimpleOperation.MULTIPLY.apply(a, b));
		System.out.println(SimpleOperation.DIVIDE.apply(a, b));
		
		System.out.println(ExtendedOperation.EXP.apply(a, b));
		System.out.println(ExtendedOperation.REMAINDER.apply(a, b));
	}
}
