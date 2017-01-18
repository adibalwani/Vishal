import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Merge class
 */
public class MergeSort {
	
	/**
	 * Sort parallely
	 *       
	 * NOTE: A threadcount of 1 indicates a single threaded sort
	 * 
	 * @param persons
	 * @param threadCount
	 * @return
	 */
	public static void parallelSort(List<Person> persons, int threadCount) {
		if (threadCount <= 1) {
			sort(persons);
			return;
		}
		
		int listSize = persons.size();
		List<Person> left = persons.subList(0, listSize / 2);
		List<Person> right = persons.subList(listSize / 2, listSize);
		
		Thread leftThread = new Thread(new MergeSortThread(left, threadCount / 2));
		Thread rightThread = new Thread(new MergeSortThread(right, threadCount / 2));
		leftThread.start();
		rightThread.start();
		
		try {
			leftThread.join();
			rightThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Collections.copy(persons, merge(left, right));
	}

	/**
	 * Sort the elements of the list in ascending order using
	 * a comparator by implementing the "merge sort" algorithm, which splits
	 * the array in half and recursively sorts the halves, then merges 
	 * the sorted halves.
	 * 
	 * @param list {@link Person}'s link
	 */
	private static void sort(List<Person> persons) {
		int listSize = persons.size();
		
		if (listSize == 1) {
			return;
		}
		
		List<Person> left = persons.subList(0, listSize / 2);
		List<Person> right = persons.subList(listSize / 2, listSize);
		
		sort(left);
		sort(right);
		
		Collections.copy(persons, merge(left, right));
	}
	
	/**
	 * Merge the two sorted lists into one sorted list to implement
	 * the 'Conquer' step of merge sort algorithm using a Comparator to do
	 * the comparison.
	 * 
	 * @param list1 A sub-list containing some of the Persons' objects.	
	 * @param list2 A sub-list containing some other Persons' objects.
	 * 
	 * @return Merged list
	 */
	private static List<Person> merge(List<Person> list1, List<Person> list2) {
		List<Person> mergedList = new ArrayList<Person>();
		int index1 = 0, index2 = 0;
		
		while (index1 < list1.size() && index2 < list2.size()) {
			Person person1 = list1.get(index1);
			Person person2 = list2.get(index2);
			
			if (person1.isOlder(person2)) {
				mergedList.add(new Person(person1));
				index1++;
			} else {
				mergedList.add(new Person(person2));
				index2++;
			}
		}
		
		int remIndex = index2 == list2.size() ? index1 : index2;
		List<Person> remList = index2 == list2.size() ? list1 : list2;
		
		while (remIndex < remList.size()) {
			mergedList.add(new Person(remList.get(remIndex)));
			remIndex++;
		}

		return mergedList;
	} 
	
	/**
	 * Parallel Thread
	 */
	private static class MergeSortThread implements Runnable {
		private List<Person> persons;
		private int threadCount;
		
		public MergeSortThread(List<Person> persons, int threadCount) {
			this.persons = persons;
			this.threadCount = threadCount;
		}
		
		@Override
		public void run() {
			MergeSort.parallelSort(persons, threadCount);
		}
	}
}
