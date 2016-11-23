package composition;

import java.util.Comparator;

public class Person implements Comparable<Person> {
	private String firstName;
	private String middleName;
	private String lastName;

	private Comparator<Person>[] comparators;

	@SuppressWarnings("unchecked")
	public void setComposedComparator(Comparator<Person>... comparators) {
		this.comparators = comparators;
	}

	public Person(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

	@Override
	public int compareTo(Person that) {
		int result = 0;
		for (Comparator<Person> comparator : comparators) {
			result = comparator.compare(this, that);
			if (result != 0) {
				return result;
			}
		}
		return result;
	}

	public static class Comparators {
		public static final Comparator<Person> FIRSTNAME = (Person p1, Person p2) -> p1.firstName
				.compareTo(p2.firstName);
		public static final Comparator<Person> MIDDLENAME = (Person p1, Person p2) -> p1.middleName
				.compareTo(p2.middleName);
		public static final Comparator<Person> LASTNAME = (Person o1, Person o2) -> o1.lastName.compareTo(o2.lastName);
	}
}
