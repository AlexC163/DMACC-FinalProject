
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RestaurantPanel extends JPanel {
	Main main = new Main();

	private JLabel title = new JLabel("Restaurant Assistant");

	private JButton addOpenTableButton = new JButton("Add Open Tables");
	private JButton sortFamiliesButton = new JButton("Sort Families");

	private JButton addNewFamilyButton = new JButton("Add New Family");
	private JTextField addNewFamilySizeField = new JTextField(5);

	private JTextField printingResultsField = new JTextField(5);
	private JButton findTableButton = new JButton("Find Table");
	private JButton printFamiliesButton = new JButton("printFamilies");

	public RestaurantPanel() {
		super();

		add(title);

		AddNewFamilyButtonListener addNewFamilyButtonListener = new AddNewFamilyButtonListener();
		addNewFamilyButton.addActionListener(addNewFamilyButtonListener);

		AddOpenTableListener addOpenTableButtonListener = new AddOpenTableListener();
		addOpenTableButton.addActionListener(addOpenTableButtonListener);

		SortFamiliesButtonListener sortFamiliesButtonListener = new SortFamiliesButtonListener();
		sortFamiliesButton.addActionListener(sortFamiliesButtonListener);

		FindTableButtonListener findTableButtonListener = new FindTableButtonListener();
		findTableButton.addActionListener(findTableButtonListener);

		PrintFamiliesButtonListener printFamiliesButtonListener = new PrintFamiliesButtonListener();
		printFamiliesButton.addActionListener(printFamiliesButtonListener);

		add(addOpenTableButton);
		add(sortFamiliesButton);

		add(addNewFamilySizeField);
		add(addNewFamilyButton);

		add(printingResultsField);
		add(findTableButton);
		add(printFamiliesButton);

	}

	class AddNewFamilyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String integerRegex = "[0-9]+";
			String strOfSizeOfFamily = addNewFamilySizeField.getText();
			int sizeOfFamily = -1;
			if (strOfSizeOfFamily.matches(integerRegex)) {
				sizeOfFamily = Integer.valueOf(strOfSizeOfFamily);
			} else {
				return;
			}

			try {
				main.addNewFamilyToQueue(sizeOfFamily);
			} catch (MaxFamilySizeExceeded e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class AddOpenTableListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				main.addOpenTable();
			} catch (MaxTableSizeExceeded e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class SortFamiliesButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			main.insertionSort();
		}
	}

	class FindTableButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String result = main.findTable();

			printingResultsField.setText(result);
		}
	}

	class PrintFamiliesButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String result = main.printFamilies();

			printingResultsField.setText(result);
		}
	}

	class ClearButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			resetFields();
		}

	}

	public void resetFields() {
		addNewFamilySizeField.setText("");
	}
}
