package panel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exception.MaxFamilySizeExceeded;
import exception.MaxTableSizeExceeded;
import exception.MinFamilySizeExceeded;
import main.Restaurant;

/**
 * Name        : RestaurantPanel
 * Created     : Nov 20, 2022
 * Course      : CIS 152 Data Structures
 * Version     : 1.0
 * OS          : macOS Monterey Version 12.2.1
 * Copyright   : This is my own original work based on
 *               specifications issued by our instructor
 * Description : array based linked list.
 * 				Input: none
 * 				Output: restaurant panel
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.
*/

@SuppressWarnings("serial")
public class RestaurantPanel extends JPanel {
	Restaurant restaurant = new Restaurant(); // Create new Restaurant object called restaurant

	private JLabel title = new JLabel("~~ Restaurant Assistant ~~"); // Create and initialize new JLabel

	private JButton addOpenTableButton = new JButton("~~~  Add Open Table  ~~~"); // Create and initialize new JButton (button)
	private JButton sortFamiliesButton = new JButton("~~~~  Sort  Families  ~~~~"); // Create and initialize new JButton (button)

	private JButton addNewFamilyButton = new JButton("Add New Family"); // Create and initialize new JButton (button)
	private JTextField addNewFamilySizeField = new JTextField(5); // Create and initialize new JTextField (text field)

	private JButton findTableButton = new JButton("Find Table"); // Create and initialize new JButton (button)
	private JButton printFamiliesButton = new JButton("Print Families"); // Create and initialize new JButton (button)
	private JTextField printingResultsField = new JTextField(20); // Create and initialize new JTextField (text field)

	/**
	 * RestaurantPanel
	 */
	public RestaurantPanel() {
		super();
		final int TITLE_WIDTH = 200; // Create and initialize new final width
		final int TITLE_HEIGHT = 10; // Create and initialize new final height
		final int TITLE_X = 40; // Create and initialize new final X
		final int TITLE_Y = 5; // Create and initialize new final Y
		title.setForeground(Color.WHITE); // Set title foreground to white
		title.setBounds(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT); // Set button at desired position with desired size
		add(title); // Add title to panel

		final int ADD_NEW_FAMILY_BUTTON_WIDTH = 140; // Create and initialize new final width
		final int ADD_NEW_FAMILY_BUTTON_HEIGHT = 25; // Create and initialize new final height
		final int ADD_NEW_FAMILY_BUTTON_X = 25; // Create and initialize new final X
		final int ADD_NEW_FAMILY_BUTTON_Y = 25; // Create and initialize new final Y
		addNewFamilyButton.setBounds(ADD_NEW_FAMILY_BUTTON_X, ADD_NEW_FAMILY_BUTTON_Y, ADD_NEW_FAMILY_BUTTON_WIDTH, ADD_NEW_FAMILY_BUTTON_HEIGHT); // Set button at desired position with desired size
		AddNewFamilyButtonListener addNewFamilyButtonListener = new AddNewFamilyButtonListener(); // Add button listener to button
		addNewFamilyButton.addActionListener(addNewFamilyButtonListener); // Add button to panel
		
		final int ADD_NEW_FAMILY_SIZE_FIELD_WIDTH = 50; // Create and initialize new final width
		final int ADD_NEW_FAMILY_SIZE_FIELD_HEIGHT = 25; // Create and initialize new final height
		final int ADD_NEW_FAMILY_SIZE_FIELD_X = 165; // Create and initialize new final X
		final int ADD_NEW_FAMILY_SIZE_FIELD_Y = 25; // Create and initialize new final Y
		addNewFamilySizeField.setBounds(ADD_NEW_FAMILY_SIZE_FIELD_X, ADD_NEW_FAMILY_SIZE_FIELD_Y, ADD_NEW_FAMILY_SIZE_FIELD_WIDTH, ADD_NEW_FAMILY_SIZE_FIELD_HEIGHT); // Set button at desired position with desired size

		final int ADD_OPEN_TABLE_BUTTON_WIDTH = 200; // Create and initialize new final width
		final int ADD_OPEN_TABLE_BUTTON_HEIGHT = 25; // Create and initialize new final height
		final int ADD_OPEN_TABLE_BUTTON_X = 25; // Create and initialize new final X
		final int ADD_OPEN_TABLE_BUTTON_Y = 60; // Create and initialize new final Y
		addOpenTableButton.setBounds(ADD_OPEN_TABLE_BUTTON_X, ADD_OPEN_TABLE_BUTTON_Y, ADD_OPEN_TABLE_BUTTON_WIDTH, ADD_OPEN_TABLE_BUTTON_HEIGHT); // Set button at desired position with desired size
		AddOpenTableListener addOpenTableButtonListener = new AddOpenTableListener(); // Add button listener to button
		addOpenTableButton.addActionListener(addOpenTableButtonListener); // Add button to panel

		final int SORT_FAMILIES_BUTTON_WIDTH = 200; // Create and initialize new final width
		final int SORT_FAMILIES_BUTTON_HEIGHT = 25; // Create and initialize new final height
		final int SORT_FAMILIES_BUTTON_X = 25; // Create and initialize new final X
		final int SORT_FAMILIES_BUTTON_Y = 95; // Create and initialize new final Y
		sortFamiliesButton.setBounds(SORT_FAMILIES_BUTTON_X, SORT_FAMILIES_BUTTON_Y, SORT_FAMILIES_BUTTON_WIDTH, SORT_FAMILIES_BUTTON_HEIGHT); // Set button at desired position with desired size
		SortFamiliesButtonListener sortFamiliesButtonListener = new SortFamiliesButtonListener(); // Add button listener to button
		sortFamiliesButton.addActionListener(sortFamiliesButtonListener); // Add button to panel

		final int FIND_TABLE_BUTTON_WIDTH = 125; // Create and initialize new final width
		final int FIND_TABLE_BUTTON_HEIGHT = 25; // Create and initialize new final height
		final int FIND_TABLE_BUTTON_X = 5; // Create and initialize new final X
		final int FIND_TABLE_BUTTON_Y = 130; // Create and initialize new final Y
		findTableButton.setBounds(FIND_TABLE_BUTTON_X, FIND_TABLE_BUTTON_Y, FIND_TABLE_BUTTON_WIDTH, FIND_TABLE_BUTTON_HEIGHT); // Set button at desired position with desired size
		FindTableButtonListener findTableButtonListener = new FindTableButtonListener(); // Add button listener to button
		findTableButton.addActionListener(findTableButtonListener); // Add button to panel

		final int PRINT_FAMILIES_BUTTON_WIDTH = 125; // Create and initialize new final width
		final int PRINT_FAMILIES_BUTTON_HEIGHT = 25; // Create and initialize new final height
		final int PRINT_FAMILIES_BUTTON_X = 125; // Create and initialize new final X
		final int PRINT_FAMILIES_BUTTON_Y = 130; // Create and initialize new final Y
		printFamiliesButton.setBounds(PRINT_FAMILIES_BUTTON_X, PRINT_FAMILIES_BUTTON_Y, PRINT_FAMILIES_BUTTON_WIDTH, PRINT_FAMILIES_BUTTON_HEIGHT); // Set button at desired position with desired size
		PrintFamiliesButtonListener printFamiliesButtonListener = new PrintFamiliesButtonListener(); // Add button listener to button
		printFamiliesButton.addActionListener(printFamiliesButtonListener); // Add button to panel
		
		final int PRINTING_RESULTS_FIELD_WIDTH = 230; // Create and initialize new final width
		final int PRINTING_RESULTS_FIELD_HEIGHT = 25; // Create and initialize new final height
		final int PRINTING_RESULTS_FIELD_X = 12; // Create and initialize new final X
		final int PRINTING_RESULTS_FIELD_Y = 165; // Create and initialize new final Y
		printingResultsField.setBounds(PRINTING_RESULTS_FIELD_X, PRINTING_RESULTS_FIELD_Y, PRINTING_RESULTS_FIELD_WIDTH, PRINTING_RESULTS_FIELD_HEIGHT); // Set button at desired position with desired size

		add(addOpenTableButton); // Add button to panel
		add(sortFamiliesButton); // Add button to panel

		add(addNewFamilyButton); // Add button to panel
		add(addNewFamilySizeField); // Add field to panel


		add(findTableButton); // Add button to panel
		add(printFamiliesButton); // Add button to panel
		add(printingResultsField); // Add field to panel

	}

	class AddNewFamilyButtonListener implements ActionListener {

		/**
		 * @param e ActionEvent
		 * @return void
		 */
		@Override
		public void actionPerformed(ActionEvent e) {			
			String integerRegex = "[0-9]+"; // Create and initialize integer regex
			String strOfSizeOfFamily = addNewFamilySizeField.getText(); // Get text in family size field
			int sizeOfFamily = -1; // Create and initialize sizeOfFamily to -1
			if (strOfSizeOfFamily.matches(integerRegex)) // If the size of family input is a number
				sizeOfFamily = Integer.valueOf(strOfSizeOfFamily); // Then set sizeOfFamily to the size of family
			else // Otherwise
				return; // Leave the program (so there are no errors)

			try {
				restaurant.addNewFamilyToQueue(sizeOfFamily); // Add family to queue
			} catch (MaxFamilySizeExceeded | MinFamilySizeExceeded e1) {
				System.out.println("Max Family Size Exceeded."); // Throw error (print statement) if max family size exceeded
			}
			
			int timeToSleepInSeconds = 2; // Create time to sleep in seconds
			int timeToSleepInMill = timeToSleepInSeconds * 100; // Get milliseconds of time to sleep in seconds
			try {
				Thread.sleep(timeToSleepInMill); // Pause program for timeToSleep seconds
			} catch (InterruptedException e1) {
				System.out.println("Operation Interrupted."); // Throw error if unable to complete
			}
			addNewFamilySizeField.setText(""); // Remove all text in familySizeField
		}
	}

	class AddOpenTableListener implements ActionListener {

		/**
		 * @param e ActionEvent
		 * @return void
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				restaurant.addOpenTable(); // Add open table to restaurant
			} catch (MaxTableSizeExceeded e1) {
				System.out.println("Max Table Size Exceeded"); // If too big of a table, throw error (print out string)
			}
		}
	}

	class SortFamiliesButtonListener implements ActionListener {

		/**
		 * @param e ActionEvent
		 * @return void
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			restaurant.insertionSort(); // Run insertion sort
		}
	}

	class FindTableButtonListener implements ActionListener {

		/**
		 * @param e ActionEvent
		 * @return void
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String result = restaurant.findTable(); // Find available table
			
			printingResultsField.setText(result); // Set text to result
			
		}
	}

	class PrintFamiliesButtonListener implements ActionListener {

		/**
		 * @param e ActionEvent
		 * @return void
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String result = restaurant.printFamilies(); // Get result
			System.out.println(result); // Print out result (unnecessary)
			printingResultsField.setText(result); // Set results text to the result

		}
	}

}
