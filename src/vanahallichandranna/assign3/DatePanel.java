/**
 * 
 */
package vanahallichandranna.assign3;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Sneha
 *
 */
//this class creates date panel
public class DatePanel extends JPanel {

	private JComboBox<String> day;
	private JComboBox<String> month;
	private JComboBox<String> year;
	
	static enum Time { START_OF_DAY, CURRENT_TIME, END_OF_DAY };
	
	/**
	 * 
	 */
	public DatePanel() {
		super();
		setSize(300, 50);
		setBorder(new LineBorder(Color.BLUE));
		month = new JComboBox<String>();
		day = new JComboBox<String>();
		year = new JComboBox<String>();
		
		initializeCalender();
		
		month.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int monthIndex = month.getSelectedIndex();
				Calendar c = Calendar.getInstance();
				c.clear();
				c.set(Calendar.MONTH, monthIndex);
				c.set(Calendar.YEAR, Integer.parseInt(year.getSelectedItem().toString()));
				Date d = c.getTime();
				int maximumDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
				day.removeAllItems();
				for(int i=0; i<maximumDays; i++) {
					day.addItem(String.valueOf(i+1));
				}
			}
		});
		
		add(month);
		add(day);
		add(year);
	}
	
	//initializes the calendar to the days, months and years
	private void initializeCalender() {
		for(int i=0; i<31; i++) {
			day.addItem(String.valueOf(i+1));
		}
		
		String[] months = { "January", "February", "March", "April",
		                    "May", "June", "July", "August",
		                    "Spetember", "October", "November", "December" };
		for(int i=0; i<12; i++) {
			month.addItem(months[i]);
		}
		
		for(int i=1950; i<2050; i++) {
			year.addItem(String.valueOf(i));
		}
		
		Calendar c = Calendar.getInstance();
		month.setSelectedIndex(c.get(Calendar.MONTH));
		day.setSelectedIndex(c.get(Calendar.DATE)-1);
		year.setSelectedItem(String.valueOf(c.get(Calendar.YEAR)));
	}
	
	
	public Date getDate(Time time) {
		int y = Integer.parseInt(year.getSelectedItem().toString());
		int m = month.getSelectedIndex();
		int d = Integer.parseInt(day.getSelectedItem().toString());
		Calendar c = Calendar.getInstance();
		if(time == Time.START_OF_DAY) {
			c.clear();
		} else if(time == Time.END_OF_DAY) {
			c.set(Calendar.HOUR_OF_DAY, 23);
			c.set(Calendar.MINUTE, 59);
			c.set(Calendar.SECOND, 59);
			c.set(Calendar.MILLISECOND, 59);
		}
		c.set(y, m, d);
		return c.getTime();
	}

	
}
