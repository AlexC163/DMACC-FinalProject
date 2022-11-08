import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Alex Cantor - amcantor
 * CIS171 31099
 * Jul 13, 2022

 * macOS Monterey Version 12.2.1
 */
public class StartProgram {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new RestaurantPanel();
		frame.add(panel);
		
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
