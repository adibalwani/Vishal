import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader class for handling inputs
 */
public class Reader {
	
	/**
	 * Return the list of {@link Person} from the given input file
	 * 
	 * @param fileName File name containing the information
	 * @return List of {@link Person}
	 */
	public static List<Person> getPersonList(String fileName) {
		BufferedReader reader = null;
		List<Person> persons = new ArrayList<Person>();
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] data = line.trim().replaceAll("\\s+", " ").split(" ");
				int id = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				int day = Integer.parseInt(data[2]);
				int year = Integer.parseInt(data[3]);
				
				Person person = new Person(id, day, month, year);
				persons.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				reader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
		return persons;
	}
}
