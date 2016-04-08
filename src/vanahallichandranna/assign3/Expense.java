/**
 * 
 */
package vanahallichandranna.assign3;

import java.util.Date;

/**
 * 
 */

/**
 * @author Sneha
 *
 */
//each expense entered by the user is depicted by this class
public class Expense {
	private String category;
	private double expenseAmount;
	private Date date;
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setExpenseAmount(double d) {
		expenseAmount = d;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public Date getDate() {
		return date;
	}

}
