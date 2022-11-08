import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testAddingFamiles() throws MaxFamilySizeExceeded {
		Main main = new Main();
		main.addNewFamilyToQueue(3);
		main.addNewFamilyToQueue(8);
		main.addNewFamilyToQueue(4);
		
		assertEquals("Family Sizes: 3, 8, 4", main.printFamilies());
	}
	
	@Test
	void testAddingFamilesFail() throws MaxFamilySizeExceeded {
		Main main = new Main();
		main.addNewFamilyToQueue(3);
		main.addNewFamilyToQueue(8);
		main.addNewFamilyToQueue(4);
		
		assertThrows(MaxFamilySizeExceeded.class, () -> main.addNewFamilyToQueue(100));
	}
	
	@Test
	void testSortingFamilies() throws MaxFamilySizeExceeded {
		Main main = new Main();
		main.addNewFamilyToQueue(7);
		main.addNewFamilyToQueue(1);
		main.addNewFamilyToQueue(9);
		
		main.insertionSort();
		
		assertEquals("Family Sizes: 1, 7, 9", main.printFamilies());
	}

	@Test
	void testPrinting() throws MaxFamilySizeExceeded {
		Main main = new Main();
		main.addNewFamilyToQueue(5);
		main.addNewFamilyToQueue(9);
		main.addNewFamilyToQueue(2);
				
		assertEquals("Family Sizes: 5, 9, 2", main.printFamilies());
	}
	
	
}
