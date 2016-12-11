package patterns.monads;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {

	public static void main(String[] args) {
		int[][] twoDArray = { { 1, 2, 3, 4, 5 }, { 9, 8, 7, 6, 5 } };
		
		System.out.println("Traditional way to print two dimensional array");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(twoDArray[i][j]);
			}
		}

		System.out.println("Using flatMap to print two dimensional array");
		IntStream.range(0, twoDArray.length)
			.flatMap(i -> IntStream.of(twoDArray[i])) // map and flattens
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("Another way using flatMap to print two dimensional array");
		Arrays.stream(twoDArray)
	      .flatMapToInt(Arrays::stream)
	      .distinct()
	      .forEach(System.out::println);
		
		System.out.println("Using Map to print two dimensional array");
		Arrays.stream(twoDArray)
	      .map(p -> p)
	      .distinct()
	      .forEach(e -> {
	    	  for (int j = 0; j < 5; j++) {
					System.out.println(e[j]);
	    	  }
	      });
		
		System.out.println("Using Map to print higher order arrays");
		Arrays.stream(twoDArray)
	      .map(p -> p)
	      .distinct()
	      .forEach(System.out::println);
		
		System.out.println("Using Map to print sum of integers in lower order arrays");
		Arrays.stream(twoDArray)
	      .map(p -> IntStream.of(p))
	      .forEach(e -> {
	    	  System.out.println(e.sum());
	      });
		
		
		String[][] friends = {{"Kishoj", "Bajracharya"}, {"Pradeep", "Prajapati"}, {"Sailesh", "Shrestha"}, {"Mohan", "Shrestha"},
				{"Dippendra", "Chaulagain"}, {"Prashanna", "Bajracharya"}};
		
		System.out.println("Using flatMap to print friends");
		Stream.of(friends)
		 	.flatMap(Arrays::stream)
		 	/* .flatMap(Stream::of)*/
		 	/*.flatMap(e -> Stream.of(e))*/
	        .forEach(System.out::println);
		
		System.out.println("Using Map to print friends");
		Arrays.stream(friends)
	    .map(a -> String.join(" ", a)).distinct()
	        .forEach(System.out::println);		
	}
	
}
