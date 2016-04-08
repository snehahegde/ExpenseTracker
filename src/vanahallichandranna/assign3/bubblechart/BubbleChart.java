package vanahallichandranna.assign3.bubblechart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


public class BubbleChart extends JPanel {
	
	ArrayList<Bubble> bubbles;
	DataSource dataSource;
	
	public BubbleChart(DataSource dataSource) {
		super();
		bubbles = new ArrayList<>();
		this.dataSource = dataSource;
		refreshData();	
	}
	
	public void refreshData() {
		ArrayList<BubbleData> bubbleData = dataSource.getBubbleData();
		if(bubbleData == null) {
			return;
		}
		bubbles.clear();
		
		Random random = new Random();
		int i=0;
		for(BubbleData d: bubbleData) {
			//Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
			
			Color color = new Color((100*(i+1) + 50)%256, (i*10)%256, ((i+1)*(i)*(i+3) + 7)%256);
			//Color color = new Color((int) (10 + (0.618033988749895f * i) % 1));
			Bubble b = new Bubble(d, color);
			bubbles.add(b);
			i += 5;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON );
		Point center = new Point(100, 200);
		double scale = 1;
		boolean up = true;
		for(Bubble b: bubbles) {
			b.paint(graphics, center, scale, up);
			center.translate(100, 0);
			up = !up;
		}
	}

}
