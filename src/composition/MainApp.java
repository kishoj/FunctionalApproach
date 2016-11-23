package composition;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		Person person1 = new Person("Khagendra", "Bahadur", "Kunwar");
		Person person2 = new Person("Ashish", "Kaji", "Sharma");
		Person person3 = new Person("Kishoj", "", "Bajracharya");
		Person person4 = new Person("Mohan", "", "Shrestha");
		Person person5 = new Person("Dippendra", "", "Chaulagain");
		
		List<Person> friends = Arrays.asList(person2, person1, person3, person4, person5);
		
		Comparator<Person> compareFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		Comparator<Person> compareMiddleName = (p1, p2) -> p1.getMiddleName().compareTo(p2.getMiddleName());
		Comparator<Person> compareLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
		
		@SuppressWarnings("unchecked")
		ComposedComparator<Person> compositeComparator = new ComposedComparator<Person>(compareFirstName,
				compareMiddleName, compareLastName);
		
		Collections.sort(friends, compositeComparator);
		System.out.println("Using Composite Comparator");
		friends.forEach(System.out::println);
		
		Collections.sort(friends, Person.Comparators.FIRSTNAME);
		System.out.println("\nUsing First Name as Comparator");
		friends.forEach(System.out::println);
		
		Collections.sort(friends, Person.Comparators.MIDDLENAME);
		System.out.println("\nUsing Middle Name as Comparator");
		friends.forEach(System.out::println);
		
		Collections.sort(friends, Person.Comparators.LASTNAME);
		System.out.println("\nUsing Last Name as Comparator");
		friends.forEach(System.out::println);
	}

}
