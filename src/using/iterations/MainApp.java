package using.iterations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MainApp {

	private static final boolean isVowel(Character vowel) {
		return Arrays.asList('a', 'e', 'i', 'o', 'u').contains(vowel.charValue());
	}

	public static Set<Character> vowelsInWord_old(String word) {
		Set<Character> result = new HashSet<Character>();
		for (Character character : word.toLowerCase().toCharArray()) {
			if (isVowel(character)) {
				result.add(character);
			}
		}
		return result;
	}

	public static final Set<Character> vowelsInWord(String word) {
		return word.toLowerCase().chars().mapToObj(character -> (char) character)
				.filter(character -> isVowel(character)).collect(Collectors.toSet());
	}

	public static void main(String[] args) {
		Set<Character> result = vowelsInWord_old("kishoj bajracharya");
		System.out.println(result.toString());
		vowelsInWord("Kishoj Bajracharya").forEach(System.out::println);
	}

}
