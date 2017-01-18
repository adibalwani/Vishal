import java.io.PrintStream;
import java.util.List;


/**
 * Writer class for handling outputs
 */
public class Writer {

	/**
	 * Write the formatted {@link Person} to the provided output stream
	 * 
	 * @param persons List of {@link Person} 
	 * @param out Output stream
	 */
	public static synchronized void writePersonList(List<Person> persons, PrintStream out) {
		for (Person person : persons) {
			out.print(person.getId());
			out.print("\t");
			out.print(person.getBirthday().getMonth());
			out.print("\t");
			out.print(person.getBirthday().getDay());
			out.print("\t");
			out.println(person.getBirthday().getYear());
		}		
	}
}
