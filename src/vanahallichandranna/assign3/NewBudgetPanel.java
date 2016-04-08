/**
 * 
 */
package vanahallichandranna.assign3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import vanahallichandranna.assign3.DatePanel.Time;

/**
 * @author Sneha
 *
 */
public class NewBudgetPanel extends JPanel {
	private JLabel setBudgetLabel;
	private JLabel categoryLabel;
	private String[] categories = new String[] {"All", "Food", "Rent", "Studies", "Entertainment", "Fuel"};
	private JComboBox<String> categoriesComboBox;
	private JButton setButton;
	private JLabel budgetLabel;
	private JTextField amountField;
	private JLabel durationLabel;
	private String[] durations = new String[] {"Day", "Month", "Year", "Custom"};
	private JComboBox<String> durationsComboBox;
	private Data data;
	private DatePanel startDatePanel;
	private DatePanel endDatePanel;
	private JLabel toLabel;
	private JLabel fromLabel;
	/**
	 * 
	 */
	public NewBudgetPanel(Data d) {
		data = d;
		setLayout(null);
		this.setLocation(Constants.NEW_BUDGET_PANEL_LOCATIONX, Constants.NEW_BUDGET_PANEL_LOCATIONY);
		setBackground(new Color( 35, 181, 175));
		this.setSize(Constants.NEW_BUDGET_PANEL_WIDTH, Constants.NEW_BUDGET_PANEL_HEIGHT);
		
		createHeaderPanel();
		setButtonPanel();
		createEntryPanel();	
	}
	
	//creates budget header panel
	private void createHeaderPanel() {
		JPanel headerPanel  = new JPanel();
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
	    Font newFont = myFont.deriveFont(36F);
		setBudgetLabel = new JLabel("Set Budget", SwingConstants.CENTER);
		setBudgetLabel.setFont(newFont);
		headerPanel.add(setBudgetLabel);
		headerPanel.setLocation(Constants.NEW_BUDGET_HEADER_PANEL_LOCATIONX, Constants.NEW_BUDGET_HEADER_PANEL_LOCATIONY);
		headerPanel.setSize(Constants.NEW_BUDGET_HEADER_PANEL_WIDTH, Constants.NEW_BUDGET_HEADER_PANEL_HEIGHT);
		this.add(headerPanel);
	}
	
	//creates budget's entry panel
	private void createEntryPanel() {
		JPanel entryPanel = new JPanel();
		entryPanel.setLocation(Constants.NEW_BUDGET_ENTRY_PANEL_LOCATIONX, Constants.NEW_BUDGET_ENTRY_PANEL_LOCATIONY);
		entryPanel.setSize(Constants.NEW_BUDGET_ENTRY_PANEL_WIDTH, Constants.NEW_BUDGET_ENTRY_PANEL_HEIGHT);
		entryPanel.setLayout(null);		
		
		JPanel categoryPanel = new JPanel();
		categoryLabel = new JLabel("Category : ");
		categoryPanel.add(categoryLabel);
		categoriesComboBox = new JComboBox<String>(categories);
		categoryPanel.add(categoriesComboBox);
		categoryPanel.setLocation(Constants.NEW_BUDGET_ENTRY_PANEL_WIDTH/4, 10);
		categoryPanel.setSize(280,60);
		entryPanel.add(categoryPanel);
				
		JPanel budgetPanel = new JPanel();
		budgetLabel = new JLabel("Budget : ");
		budgetPanel.add(budgetLabel);
		amountField = new JTextField(5);
		budgetPanel.add(amountField);
		
		budgetPanel.setLocation(Constants.NEW_BUDGET_ENTRY_PANEL_WIDTH/4, 80);
		budgetPanel.setSize(280,60);
		entryPanel.add(budgetPanel);
		
		//duration allows to select handy options day,week,month,year and custom
		JPanel durationPanel = new JPanel();
		durationLabel = new JLabel("Duration : ");
		durationPanel.add(durationLabel);
		durationsComboBox = new JComboBox<String>(durations);
		durationPanel.add(durationsComboBox);
		durationPanel.setLocation(Constants.NEW_BUDGET_ENTRY_PANEL_WIDTH/4, 150);
		durationPanel.setSize(280,60);
		entryPanel.add(durationPanel);	
		
		//from date
		fromLabel = new JLabel("From : ");
		fromLabel.setLocation(10, 220);
		fromLabel.setSize(70, 50);
		entryPanel.add(fromLabel);
		
		startDatePanel = new DatePanel();
		startDatePanel.setLocation(50, 220);
		startDatePanel.setSize(300, 50);
		entryPanel.add(startDatePanel);
		
		//to date
		toLabel = new JLabel("To : ");
		toLabel.setLocation(360, 220);
		toLabel.setSize(40, 50);
		entryPanel.add(toLabel);

		endDatePanel = new DatePanel();
		endDatePanel.setLocation(410, 220);
		endDatePanel.setSize(300, 50);
		entryPanel.add(endDatePanel);

		this.add(entryPanel);		
	}		
	
	//creates the set button and has its associated action listener
	private void setButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLocation(Constants.NEW_BUDGET_BUTTON_PANEL_LOCATIONX, Constants.NEW_BUDGET_BUTTON_PANEL_LOCATIONY);
		buttonPanel.setSize(Constants.NEW_BUDGET_BUTTON_PANEL_WIDTH,Constants.NEW_BUDGET_BUTTON_PANEL_HEIGHT);
		buttonPanel.setLayout(null);
		
		setButton = new JButton("Set");
		setButton.setLocation((Constants.NEW_BUDGET_ENTRY_PANEL_WIDTH - 150)/2, 10);
		setButton.setSize(130,30);	
		buttonPanel.add(setButton);
		this.add(buttonPanel);
		
		//this action listener sets the budget for selected category(All or any individual category)
		// and the time period selected
		setButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String categorySelected = (String)categoriesComboBox.getSelectedItem();
				String durationSelected = (String)durationsComboBox.getSelectedItem();

				Date startDate;
				Date endDate;

				if (durationSelected == "Custom") {
					startDate = startDatePanel.getDate(Time.START_OF_DAY);
					endDate = endDatePanel.getDate(Time.END_OF_DAY);
				} else {
					Calendar startCalender = new GregorianCalendar();
					startCalender.set(Calendar.HOUR_OF_DAY, 0);
					startCalender.set(Calendar.MINUTE, 0);
					startCalender.set(Calendar.SECOND, 0);
					startCalender.set(Calendar.MILLISECOND, 0);
	
					Calendar endCalender = new GregorianCalendar();
					endCalender.set(Calendar.HOUR_OF_DAY, 23);
					endCalender.set(Calendar.MINUTE, 59);
					endCalender.set(Calendar.SECOND, 59);
					endCalender.set(Calendar.MILLISECOND, 59);
				
					if(durationSelected == "Day") {
						// Noop
					} else if(durationSelected == "Month") {
						if(endCalender.get(Calendar.MONTH) == Calendar.DECEMBER) {
							endCalender.roll(Calendar.YEAR, true);
						}
						endCalender.roll(Calendar.MONTH, true);
						endCalender.add(Calendar.DAY_OF_MONTH, -1);
						
					} else if(durationSelected == "Year") {
						endCalender.roll(Calendar.YEAR, true);
						endCalender.add(Calendar.DAY_OF_MONTH, -1);
					}
					
					startDate = startCalender.getTime();
					endDate = endCalender.getTime();
				}
				
				if (endDate.before(startDate)) {
					JOptionPane.showMessageDialog(null, "End date should be greater or equal to the start date");
					return;
				}
				
				BudgetPeriod budgetPeriod = new BudgetPeriod(startDate, endDate);
				
				double amount = 0;
				try {
					amount = Double.parseDouble(amountField.getText()); 
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Amount cannot be empty");
					return;
				}
				
				Budget budget = new Budget(categorySelected, budgetPeriod, amount);
				data.setBudget(categorySelected, budgetPeriod, budget);
			}
		});
	}
	
}
