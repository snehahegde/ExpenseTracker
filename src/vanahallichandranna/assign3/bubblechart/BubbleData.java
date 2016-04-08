package vanahallichandranna.assign3.bubblechart;

public class BubbleData {
	double maxValue;
	double currentValue;
	String label;
	
	public BubbleData(double maxValue, double currentValue, String label) {
		this.maxValue = maxValue;
		this.currentValue = currentValue;
		this.label = label;
	}
	
	double getMaxValue() {
		return maxValue;
	}
	
	double getCurrentValue() {
		return currentValue;
	}
	
	String getLabel() {
		return label;
	}
}
