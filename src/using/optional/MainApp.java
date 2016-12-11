package using.optional;

import java.util.Optional;

public class MainApp {
	
	private static String getValueFromOptional(Optional<String> maybeValue) {
		return maybeValue.isPresent() ? maybeValue.get() : null;
	}

	public static void main(String[] args) {
		Optional<String> firstName = Optional.ofNullable("Kishoj");
		Optional<String> middleName = Optional.ofNullable(null);
		Optional<String> lastName = Optional.ofNullable("Bajracharya");
		
		Student student = new Student(getValueFromOptional(firstName), getValueFromOptional(middleName), getValueFromOptional(lastName));
		System.out.println(student);
	}
}
