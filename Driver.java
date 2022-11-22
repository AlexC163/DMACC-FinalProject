import exception.MaxFamilySizeExceeded;
import exception.MinFamilySizeExceeded;
import main.Restaurant;

/**
 * Name        : Driver
 * Created     : Nov 20, 2022
 * Course      : CIS 152 Data Structures
 * Version     : 1.0
 * OS          : macOS Monterey Version 12.2.1
 * Copyright   : This is my own original work based on
 *               specifications issued by our instructor
 * Description : array based linked list.
 * 				Input: none
 * 				Output: driver of restaurant
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.
*/

public class Driver {
	public static void main(String[] args) throws MaxFamilySizeExceeded, MinFamilySizeExceeded {
		Restaurant restaurant = new Restaurant(); // Create Restaurant object called restaurant
		restaurant.addNewFamilyToQueue(3); // Add new family with size 3 to restaurant queue
		restaurant.addNewFamilyToQueue(8); // Add new family with size 8 to restaurant queue
		restaurant.addNewFamilyToQueue(4); // Add new family with size 4 to restaurant queue
		
		System.out.println(restaurant.printFamilies()); // Print out all families
		restaurant.insertionSort(); // Use insertion sort to sort all families
		System.out.println(restaurant.printFamilies()); // Print out all families
	}
}
