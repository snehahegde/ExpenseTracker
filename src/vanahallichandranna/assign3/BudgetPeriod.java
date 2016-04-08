/**
 * 
 */
package vanahallichandranna.assign3;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author Sneha
 *
 */
//this class specifies duration of the period
public class BudgetPeriod {
	private Date startDate;
	private Date endDate;

	/**
	 * 
	 */
	public BudgetPeriod(Date fromDate, Date toDate) {
		startDate = fromDate;
		endDate = toDate;		
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	//computes the hash of the budget	
	@Override
	public int hashCode() {
		
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTime(startDate);
		
		int h = 100000*c.get(Calendar.YEAR)+10000*c.get(Calendar.MONTH)+1000*c.get(Calendar.DATE);
		c.clear();
		c.setTime(endDate);
		h += 100*c.get(Calendar.YEAR)+10*c.get(Calendar.MONTH)+1*c.get(Calendar.DATE);
		
		return h;
		
		
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof BudgetPeriod) {
			BudgetPeriod bp = (BudgetPeriod) o;
			return (bp.startDate.equals(startDate) && bp.endDate.equals(endDate));
		}
		return false;
	}

}
