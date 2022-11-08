
public class Driver {
	public static void main(String[] args) throws MaxFamilySizeExceeded {
		Main main = new Main();
		main.addNewFamilyToQueue(3);
		main.addNewFamilyToQueue(8);
		main.addNewFamilyToQueue(4);
		
		System.out.println(main.printFamilies());
		main.insertionSort();
		System.out.println(main.printFamilies());
	}
}
