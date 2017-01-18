/**
 * Birthday defined by day, month and year
 * 
 * TODO: Month and year should be ENUM
 * TODO: Day validation
 */
public class Birthday implements Comparable<Birthday> {
	
	/*
	 * Day of the month
	 */
	private int day;
	
	/*
	 * Month of the year
	 */
	private int month;
	
	/*
	 * Birth Year
	 */
	private int year;
	
	public Birthday(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/*
	 * Copy constructor
	 */
	public Birthday(Birthday birthday) {
		this.day = birthday.getDay();
		this.month = birthday.getMonth();
		this.year = birthday.getYear();
	}
	
	@Override
	public int compareTo(Birthday birthday) {
		int diff = this.year - birthday.getYear();
		if (diff == 0) {
			diff = this.month - birthday.getMonth();
			if (diff == 0) {
				diff = this.day - birthday.getDay();
			}
		}
		
		return diff;
	}

	/*
	 * Getter methods
	 */
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
}
