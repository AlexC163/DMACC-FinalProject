import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.RestaurantPanel;

/**
 * Name        : StartProgram
 * Created     : Nov 20, 2022
 * Course      : CIS 152 Data Structures
 * Version     : 1.0
 * OS          : macOS Monterey Version 12.2.1
 * Copyright   : This is my own original work based on
 *               specifications issued by our instructor
 * Description : array based linked list.
 * 				Input: none
 * 				Output: start program for program
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or 
 * unmodified. I have not given other fellow student(s) access to
 * my program.
*/

public class StartProgram {
	
	public static void main(String[] args) {
		final int FRAME_X = 250; // Set frame X size
		final int FRAME_Y = 250; // Set frame Y size
		JFrame frame = new JFrame(); // Initialize new frame
		JPanel panel = new RestaurantPanel(); // Initialize new panel with the Restaurant Panel
		panel.setBackground(Color.black); // Set panel background black
		panel.setLayout(null); // Set layout as null
		frame.add(panel); // Add panel to frame

		frame.setSize(FRAME_X, FRAME_Y); // Set size of frame

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		frame.setVisible(true); // Set frame as visible
	}
}
