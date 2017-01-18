import java.util.List;

/**
 * PRIORITY 2 : Implement your own sorting. Give the time and space 
 * complexity of your algorithm.
 *
 * This program reads the input file containing people's birthdays
 * and sorts the records in parallel using 2 threads, by the full 
 * date of birth in ascending order, records with same year are 
 * sorted by month and records with same month are sorted by day.
 * 
 * This program implements merge sort algorithm in parallel.
 * 
 * @author Vishal Mehta
 * 
 * TODO: Redefine packages
 */
public class Application {
	
	public static void main(String[] args) {
		List<Person> persons = Reader.getPersonList(Constant.INPUT_FILE_NAME);
		MergeSort.parallelSort(persons, 2);
		Writer.writePersonList(persons, System.out);
	}
}
