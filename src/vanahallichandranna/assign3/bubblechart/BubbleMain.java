package vanahallichandranna.assign3.bubblechart;

import javax.swing.JFrame;


public class BubbleMain {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Bubble Chart");
		mainFrame.setSize(800, 800);
		BubbleDataSource dataSource = new BubbleDataSource(10);
		BubbleChart chart = new BubbleChart(dataSource);
		mainFrame.add(chart);
		mainFrame.setVisible(true);
		
	}

}
