/**
 * Person with an id and birthday
 * 
 * TODO: Create a factory class for person that ensures unique ID
 */
public class Person implements Comparable<Person> {
	
	/*
	 * Id of the person
	 */
	private int id;
	
	/*
	 * Birthday of the person
	 */
	private Birthday birthday;
	
	public Person(int id, int day, int month, int year) {
		Birthday birthday = new Birthday(day, month, year);
		this.id = id;
		this.birthday = birthday;
	}
	
	/*
	 * Copy constructor
	 */
	public Person(Person person) {
		this.id = person.getId();
		this.birthday = new Birthday(person.getBirthday());
	}
	
	@Override
	public int compareTo(Person person) {
		Birthday birthday = person.getBirthday();
		return this.birthday.compareTo(birthday);
	}
	
	/**
	 * Check whether the person is older than the given one
	 * 
	 * @param person The given person
	 */
	public boolean isOlder(Person person) {
		Birthday birthday = person.getBirthday();
		return this.birthday.compareTo(birthday) < 0;
	}
	
	/*
	 * Getter methods
	 */
	public int getId() {
		return id;
	}

	public Birthday getBirthday() {
		return birthday;
	}
}
