package vanahallichandranna.assign3.bubblechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;


public class Bubble {

	BubbleData bubbleData;
	Color color;
	
	public Bubble(BubbleData bubbleData, Color color) {
		this.bubbleData = bubbleData;
		this.color = color;
	}
	
	public void paint(Graphics2D g, Point center, double scale, boolean up) {
		Color oldColor = g.getColor();
		g.setColor(color);
		
		// Draw the bubbles
		
		// Draw max value circle
		//int largerBubbleSize = (int) (bubbleData.getMaxValue()*scale);
		double largerArea = bubbleData.getMaxValue();
		int largerBubbleRadius = (int) Math.sqrt(largerArea/Math.PI);
		
		int topLeftX = center.x - largerBubbleRadius;
		int topLeftY = center.y - largerBubbleRadius;

		//double largerArea = Math.PI*largerBubbleSize*largerBubbleSize/4;
		double smallerArea = largerArea*bubbleData.getCurrentValue()/bubbleData.getMaxValue();
		
		int smallerBubbleRadius = (int) Math.sqrt(smallerArea/Math.PI);
		
		
		g.setColor(this.color.darker());
		g.fillOval(topLeftX, topLeftY, 2*largerBubbleRadius, 2*largerBubbleRadius);
		
		// Draw current value circle
		/*
		int smallerBubbleSize = (int) (bubbleData.getCurrentValue()*scale);
		topLeftX = center.x - smallerBubbleSize/2;
		topLeftY = center.y - smallerBubbleSize/2;
		*/
		topLeftX = center.x - smallerBubbleRadius;
		topLeftY = center.y - smallerBubbleRadius;
		
		int offset = largerBubbleRadius-smallerBubbleRadius;
		topLeftY += offset;
		g.setColor(this.color.brighter());
		g.fillOval(topLeftX, topLeftY, 2*smallerBubbleRadius, 2*smallerBubbleRadius);
		
		
		offset = center.y + 200;
		if(up) {
			offset += 5;
		} else {
			offset -= 5;
		}
		g.setColor(Color.LIGHT_GRAY);
		g.setStroke(new BasicStroke(1));
		
		g.setColor(this.color.darker());
		topLeftX = center.x - largerBubbleRadius;
		topLeftY = center.y - largerBubbleRadius;
		g.drawOval(topLeftX, topLeftY, 2*largerBubbleRadius, 2*largerBubbleRadius);
		
		
		g.drawLine(center.x, center.y+largerBubbleRadius, center.x, offset);
		g.setColor(Color.GRAY);
		String label = bubbleData.getLabel();
		g.drawString(label, center.x, offset + 20);
		g.setColor(oldColor);
		
	}
}
