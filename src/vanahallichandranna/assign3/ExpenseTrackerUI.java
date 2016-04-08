package vanahallichandranna.assign3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;

public class ExpenseTrackerUI {
	private Data data;
	public ExpenseTrackerUI(Data d) {
		data = d;
	}
	
	public void run() {
		// the JFrame which holds all the panels
		JFrame mainFrame = new JFrame("Expense Tracker");
		mainFrame.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		mainFrame.setLayout(null);
		
		MainPanel mainPanel = new MainPanel(data);
		mainFrame.add(mainPanel);
		
		mainFrame.setVisible(true);
	}
}
