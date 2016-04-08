/**
 * 
 */
package vanahallichandranna.assign3;

import java.time.Period;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Sneha
 *
 */
public class BudgetPerCategory {

	private HashMap<BudgetPeriod, Budget> budgets;
	
	public BudgetPerCategory() {
		budgets = new HashMap<BudgetPeriod, Budget>();
	}
	
	//sets the budget for a given period and category
	public void setBudget(BudgetPeriod budgetPeriod, Budget budget) {
		System.out.println("set budget");
		Set<BudgetPeriod> keys = budgets.keySet();
		for(BudgetPeriod bp: keys) {
			System.out.println(bp.getStartDate() + " " + bp.getEndDate());
			System.out.println("Hash: " + bp.hashCode());
		}
		System.out.println(keys);
		budgets.put(budgetPeriod, budget);
	}
	
	//gets the budget for the period given
	public Budget getBudget(BudgetPeriod period) {
		Set<BudgetPeriod> keys = budgets.keySet();
		for(BudgetPeriod p: keys) {
			System.out.println(period.getStartDate().equals(p.getStartDate()));
			System.out.println(period.getEndDate().equals(p.getEndDate()));
			if(period.getStartDate().equals(p.getStartDate()) && period.getEndDate().equals(p.getEndDate())) {
				return budgets.get(p);
			}
		}
		return null;
		//return budgets.get(period);
	}
	
	public HashMap<BudgetPeriod, Budget> getBudgets() {
		return budgets;
	}
}
