import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

// IMPORTANT NOTE: Table Size AND Family Size is from 1 to 10
public class Main {
	private final int MAX_TABLE_SIZE = 10;
	private final int MAX_FAMILY_SIZE = 10;
	PriorityQueue<Integer> tables;
	Queue<Integer> families;

	public Main() {
		tables = new PriorityQueue<Integer>();
		families = new LinkedList<Integer>();
	}

	public void addOpenTable() throws MaxTableSizeExceeded {
		int randomTableSize = generateRandomNum(MAX_TABLE_SIZE);
		tables.add(randomTableSize);
	}

	public void addNewFamilyToQueue(int familySize) throws MaxFamilySizeExceeded {
		if (familySize > MAX_FAMILY_SIZE) throw new MaxFamilySizeExceeded();
		families.add(familySize);
	}

	public void insertionSort() {
		if (families.size() == 0)
			return;
		int arr[] = new int[families.size()];
		for (int i = 0; i < families.size() + 2; i++) {
			arr[i] = families.poll();
		}

		int arrLen = arr.length;
		for (int i = 1; i < arrLen; i++) {
			int b = i - 1;
			int key = arr[i];
			while (b >= 0 && arr[b] > key)
				arr[b + 1] = arr[b--];
			arr[b + 1] = key;
		}

		for (int i = 0; i < arrLen; i++) {
			families.add(arr[i]);
		}
	}

	public String findTable() {
		if (families.size() == 0 && tables.size() == 0)
			return "No families to assign to a table and no tables available for families!";
		if (families.size() == 0)
			return "No families to assign to a table!";
		if (tables.size() == 0)
			return "No tables for available families!";
		
		int largestFamily = findLargestFamily();
		int bestTable = findBestTable(largestFamily);
		
		return "The family with size " + largestFamily + " recieved a table with size " + bestTable + "!";
	}

	public String printFamilies() {
		return "Family Sizes: " + families.toString().replace("[", "").replace("]", "");
	}

	private int findLargestFamily() {
		if (families.size() == 0) return -1;
		
		int largestFamilySize = -1;
		Iterator<Integer> familyIterator = families.iterator();
		
		while (familyIterator.hasNext()) {
			int nextFamily = familyIterator.next();
			if (largestFamilySize < nextFamily) {
				largestFamilySize = nextFamily;
			}
		}
		
		families.remove(largestFamilySize);
		return largestFamilySize;
	}
	
	private int findBestTable(int familySize) {
		if (familySize == 0 || tables.size() == 0) return -1;
		
		Iterator<Integer> tablesIterator = tables.iterator();
		while (tablesIterator.hasNext()) {
			int tableVal = tablesIterator.next();
			
			if (tableVal >= familySize) {
				tables.remove(tableVal);
				return tableVal;
			}
		}
		
		return -1;
	}

	private int generateRandomNum(int max) throws MaxTableSizeExceeded {
		if (max > 10) throw new MaxTableSizeExceeded();
		return new Random().nextInt(max - 1) + 1;
	}

}
