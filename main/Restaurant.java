package main;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import exception.MaxFamilySizeExceeded;
import exception.MaxTableSizeExceeded;
import exception.MinFamilySizeExceeded;

/**
 * Name        : Restaurant
 * Created     : Nov 20, 2022
 * Course      : CIS 152 Data Structures
 * Version     : 1.0
 * OS          : macOS Monterey Version 12.2.1
 * Copyright   : This is my own original work based on
 *               specifications issued by our instructor
 * Description : array based linked list.
 * 				Input: none
 * 				Output: implementation of Restaurant class.
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.
*/

/**
 * Restaurant
 */
public class Restaurant {
	private final int MAX_TABLE_SIZE = 10; // Create max table size
	private final int MAX_FAMILY_SIZE = 10; // Create max family size
	private final int LOW_SIZE = 1; // Create lowest size (for family and table)
	PriorityQueue<Integer> tables; // Create new Priority Queue of tables
	Queue<Integer> families; // Create new Queue of families

	/**
	 * Restaurant
	 */
	public Restaurant() {
		tables = new PriorityQueue<Integer>(); // Initialize tables with a Priority Queue
		families = new LinkedList<Integer>(); // Initialize families with a linked list
	}

	/**
	 * @return void
	 * @throws MaxTableSizeExceeded
	 */
	public void addOpenTable() throws MaxTableSizeExceeded {
		int randomTableSize = generateRandomNum(MAX_TABLE_SIZE); // Generate random number as table size
		tables.add(randomTableSize); // Add random table size to tables Priority Queue
	}

	/**
	 * 
	 * @param familySize
	 * @return void
	 * @throws MaxFamilySizeExceeded
	 * @throws MinFamilySizeExceeded
	 */
	public void addNewFamilyToQueue(int familySize) throws MaxFamilySizeExceeded, MinFamilySizeExceeded {
		if (familySize > MAX_FAMILY_SIZE) throw new MaxFamilySizeExceeded(); // Throw MaxFamilySizeExceeded() error if family size exceeded MAX_FAMLIY_SIZE
		if (familySize < LOW_SIZE) throw new MinFamilySizeExceeded(); // Throw MinFamilySizeExceeded() error if family size does not reach MIN_FAMLIY_SIZE
		families.add(familySize); // Adds family size to families queue
	}

	/**
	 * @return void
	 */
	public void insertionSort() {
		if (families.size() == 0) return; // If no families in family queue then return
		
		int familyArr[] = new int[families.size()]; // Create and initialize array
		
		int origFamiliesSize = families.size(); // Create orig family queue size. VERY IMPORTANT.
		// Assign all families to familyArr
		for (int i = 0; i < origFamiliesSize; i++) familyArr[i] = families.poll();
		
		// Perform insertion sort | Modified Code: Credit: GeeksForGeeks
        for (int i = 1; i < origFamiliesSize; ++i) {
            int key = familyArr[i];
            int r = i - 1;

            while (r >= 0 && familyArr[r] > key) {
                familyArr[r + 1] = familyArr[r];
                r = r - 1;
            }
            familyArr[r + 1] = key;
        }
        
        // Fill families queue with sorted familyArr
        for (int i = 0; i < origFamiliesSize; i++) families.add(familyArr[i]);
    }

	/**
	 * @return String
	 */
	public String findTable() {
		// Return "No family or table for assignment!" if no families and no tables in queue
		if ((families.size() == 0 && tables.size() == 0))
			return "No family or table for assignment!";
		// Return "No families to assign to a table" if no families in queue
		if (families.size() == 0)
			return "No families to assign to a table!";
		// Return "No tables available for families" if no tables in queue
		if (tables.size() == 0)
			return "No tables for available families!";
		
		int largestFamily = findLargestFamily(); // Find largest available family
		int bestTable = findBestTable(largestFamily); // Find best table for family
		if (bestTable == -1 || largestFamily == -1) return ""; // Final check
		return "Size " + bestTable + " recieved size " + largestFamily + " family!"; // Return needed information as a String
	}

	/**
	 * @return String
	 */
	public String printFamilies() {
		if (families.size() == 0) return "No families available to print."; // Return message if no families available to print
		return "Family Sizes: " + families.toString().replace("[", "").replace("]", ""); // Return all families
	}

	/**
	 * @return int
	 */
	private int findLargestFamily() {
		if (families.size() == 0) return -1; // Return -1 if no families
		
		int largestFamilySize = -1; // Initialize new largest family size
		Iterator<Integer> familyIterator = families.iterator(); // Initialize new family iterator
		
		// Iterate through familyIterator and find largest family
		while (familyIterator.hasNext()) {
			int nextFamily = familyIterator.next(); // Set next family to next family in iterator
			if (largestFamilySize < nextFamily) // If the next family is larger than the largest family
				largestFamilySize = nextFamily; // then set the largest family to the next family size
		}
		
		families.remove(largestFamilySize); // Remove largest family from families queue
		return largestFamilySize; // Return largest family size
	}

	/**
	 * @param familySize
	 * @return int
	 */
	private int findBestTable(int familySize) {
		if (familySize == 0 || tables.size() == 0) return -1; // Return -1 if no family or table available
		
		Iterator<Integer> tablesIterator = tables.iterator(); // Create new tables iterator
		// Loop through tables queue
		while (tablesIterator.hasNext()) {
			int tableVal = tablesIterator.next(); // find next table
			
			if (tableVal >= familySize) { // If table value is greater or equal to family size
				tables.remove(tableVal); // Remove table from tables queue
				return tableVal; // Return that table value
			}
		}

		return -1; // Code will never reach this point - based on pure logic
	}

	/**
	 * @param max
	 * @return int
	 * @throws MaxTableSizeExceeded
	 */
	private int generateRandomNum(int max) throws MaxTableSizeExceeded {
		if (max > MAX_TABLE_SIZE) throw new MaxTableSizeExceeded(); // Throw MaxTableSizeExceeded error if max table size exceeded
		return new Random().nextInt(max - 1) + 1; // Return random number from 1 to max
	}

}
