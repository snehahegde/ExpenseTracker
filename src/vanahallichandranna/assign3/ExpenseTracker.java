/**
 * 
 */
package vanahallichandranna.assign3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Sneha
 *
 */
public class ExpenseTracker {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExpenseTrackerUI ui = new ExpenseTrackerUI(new Data());
		ui.run();
	}

}
