/**
 * 
 */
package vanahallichandranna.assign3;

import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Sneha
 *
 */
public class Data {
	private HashMap<String, BudgetPerCategory> budgets; //category and budget per category mapping
	private ArrayList<Expense> expenses; //expenses stored as a list
	private double totalBudget; //total budget amount set for all the categories 

	/**
	 * 
	 */
	public Data() {
		totalBudget = 0;
		budgets = new HashMap<String, BudgetPerCategory>();
		expenses = new ArrayList<Expense>();
	}
	
	public HashMap<String, BudgetPerCategory> getBudgets() {
		return budgets;
	}
	
	public Budget getBudget(String category, BudgetPeriod period) {
		if(budgets.containsKey(category)) {
			return budgets.get(category).getBudget(period);
		}
		return null;
	}
	
	public ArrayList<Expense> getExpenses() {
		return expenses;
	}
	
	//gets the expense given the category and the period
	public double getExpense(String category, BudgetPeriod period) {
		double amount = 0;
		//for each expense if the category is the selected category and between the period
		//its expense is added to the amount
		for(Expense expense: expenses) {
			if(expense.getCategory() == category &&
					expense.getDate().after(period.getStartDate()) &&
					expense.getDate().before(period.getEndDate()) ) {
				amount += expense.getExpenseAmount();
			}
		}
		return amount;
	}
	
	//returns the total budget set
	public double getTotalBudget() {
		return totalBudget;
	}
	
	//sets the budget by category, period and the budget object
	public void setBudget(String category, BudgetPeriod budgetPeriod, Budget budget) {
		BudgetPerCategory categoryBudget = null;
		if( this.budgets.containsKey(category)) {
			categoryBudget = this.budgets.get(category);
		} else {
			categoryBudget = new BudgetPerCategory();
		}
		categoryBudget.setBudget(budgetPeriod, budget);
		this.budgets.put(category, categoryBudget);
		System.out.println(this.budgets.get(category).getBudgets().values());
	}
	
	public  void setExpense(Expense expense) {
		expenses.add(expense);
	}
	
	public void setTotalBudget(Double budget) {
		totalBudget = budget;
	}
}
