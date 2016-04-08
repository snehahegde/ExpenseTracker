package vanahallichandranna.assign3.bubblechart;

import java.util.ArrayList;
import java.util.Random;


public class BubbleDataSource implements DataSource {

	int dataCount;
	
	public BubbleDataSource(int dataCount) {
		this.dataCount = dataCount;
	}
	
	@Override
	public ArrayList<BubbleData> getBubbleData() {
		ArrayList<BubbleData> data = new ArrayList<>();
		int max = 100;
		for(int i=0; i<dataCount; i++) {
			BubbleData b = new BubbleData( 20*(i+1), 10*(i+1)+i, "Label " + String.valueOf(i+1));
			data.add(b);
		}
		return data;
	}

}
