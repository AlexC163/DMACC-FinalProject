package test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.MaxFamilySizeExceeded;
import exception.MinFamilySizeExceeded;
import main.Restaurant;

/**
 * Name        : RestaurantTest
 * Created     : Nov 20, 2022
 * Course      : CIS 152 Data Structures
 * Version     : 1.0
 * OS          : macOS Monterey Version 12.2.1
 * Copyright   : This is my own original work based on
 *               specifications issued by our instructor
 * Description : array based linked list.
 * 				Input: none
 * 				Output: restaurant tests
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.
*/

/**
 * RestaurantTest
 */
class RestaurantTest {

	/**
	 * Test adding families
	 * 
	 * @throws MaxFamilySizeExceeded
	 * @throws MinFamilySizeExceeded
	 */
	@Test
	void testAddingFamiles() throws MaxFamilySizeExceeded, MinFamilySizeExceeded {
		Restaurant restaurant = new Restaurant(); // Create new restaurant object
		restaurant.addNewFamilyToQueue(3); // Add new family with size 3 to restaurant queue
		restaurant.addNewFamilyToQueue(8); // Add new family with size 8 to restaurant queue
		restaurant.addNewFamilyToQueue(4); // Add new family with size 4 to restaurant queue
		
		assertEquals("Family Sizes: 3, 8, 4", restaurant.printFamilies()); // Check if output matches
	}

	/**
	 * Test adding families MAX FAILS
	 * 
	 * @throws MaxFamilySizeExceeded
	 * @throws MinFamilySizeExceeded
	 */
	@Test
	void testAddingFamilesMaxFail() throws MaxFamilySizeExceeded, MinFamilySizeExceeded {
		Restaurant restaurant = new Restaurant(); // Create new restaurant object
		restaurant.addNewFamilyToQueue(3); // Add new family with size 3 to restaurant queue
		restaurant.addNewFamilyToQueue(8); // Add new family with size 8 to restaurant queue
		restaurant.addNewFamilyToQueue(4); // Add new family with size 4 to restaurant queue
		
		assertThrows(MaxFamilySizeExceeded.class, () -> restaurant.addNewFamilyToQueue(100)); // Add family with exceeding size to queue
	}
	
	/**
	 * Test adding families MIN FAILS
	 * 
	 * @throws MaxFamilySizeExceeded
	 * @throws MinFamilySizeExceeded
	 */
	@Test
	void testAddingFamilesMinFail() throws MaxFamilySizeExceeded, MinFamilySizeExceeded {
		Restaurant restaurant = new Restaurant(); // Create new restaurant object
		restaurant.addNewFamilyToQueue(3); // Add new family with size 3 to restaurant queue
		restaurant.addNewFamilyToQueue(8); // Add new family with size 8 to restaurant queue
		restaurant.addNewFamilyToQueue(4); // Add new family with size 4 to restaurant queue
		
		assertThrows(MinFamilySizeExceeded.class, () -> restaurant.addNewFamilyToQueue(0)); // Add family with under-minimum size to queue
	}
	
	/**
	 * Test sorting families
	 * 
	 * @throws MaxFamilySizeExceeded
	 * @throws MinFamilySizeExceeded
	 */
	@Test
	void testSortingFamilies() throws MaxFamilySizeExceeded, MinFamilySizeExceeded {
		Restaurant restaurant = new Restaurant(); // Create new restaurant object
		restaurant.addNewFamilyToQueue(7); // Add new family with size 7 to restaurant queue
		restaurant.addNewFamilyToQueue(1); // Add new family with size 1 to restaurant queue
		restaurant.addNewFamilyToQueue(9); // Add new family with size 9 to restaurant queue
		
		restaurant.insertionSort(); // Sort family sizes using insertion sort
		
		assertEquals("Family Sizes: 1, 7, 9", restaurant.printFamilies()); // Check if output matches
	}

	/**
	 * Test printing
	 * 
	 * @throws MaxFamilySizeExceeded
	 * @throws MinFamilySizeExceeded
	 */
	@Test
	void testPrinting() throws MaxFamilySizeExceeded, MinFamilySizeExceeded {
		Restaurant restaurant = new Restaurant(); // Create new restaurant object
		restaurant.addNewFamilyToQueue(5); // Add new family with size 5 to restaurant queue
		restaurant.addNewFamilyToQueue(9); // Add new family with size 9 to restaurant queue
		restaurant.addNewFamilyToQueue(2); // Add new family with size 2 to restaurant queue
				
		assertEquals("Family Sizes: 5, 9, 2", restaurant.printFamilies()); // Check if output matches
	}
	
	
}
