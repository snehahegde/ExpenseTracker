/**
 * 
 */
package vanahallichandranna.assign3;

import java.time.Duration;
import java.time.Period;

/**
 * @author Sneha
 *
 */
//depicts the budget for a particular period and amount
public class Budget {

	private String category;
	private BudgetPeriod budgetPeriod;
	private double amount;
	
	/**
	 * 
	 */
	public Budget(String category, BudgetPeriod period, double amount) {
		this.category = category;
		this.budgetPeriod = period;
		this.amount = amount;
	}
	
	//returns the budget amount set
	public double getAmount() {
		return amount;
	}

}
