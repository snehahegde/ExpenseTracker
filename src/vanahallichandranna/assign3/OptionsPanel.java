/**
 * 
 */
package vanahallichandranna.assign3;

import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Sneha
 *
 */
public class OptionsPanel extends JPanel {
	private JButton trackSpendingButton;
	private JButton setBudgetButton;
	private JButton addExpenseButton;
	private MainPanel mainPanel;
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	//options panel contains various options to the user
	public OptionsPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		setLayout(null);
		setSize(Constants.OPTIONS_PANEL_WIDTH, Constants.OPTIONS_PANEL_HEIGHT);
		this.setLocation(Constants.OPTIONS_PANEL_LOCATIONX, Constants.OPTIONS_PANEL_LOCATIONY);
		setBackground(new Color( 35, 181, 175));
		createOptions();
	}
	
	//creates various options to add, set and track
	private void createOptions() {
		
		trackSpendingButton = new JButton("Track Spending");
		trackSpendingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		trackSpendingButton.setLocation(10, 10);
		trackSpendingButton.setSize(Constants.OPTIONS_BUTTON_WIDTH, Constants.OPTIONS_BUTTON_HEIGHT);
		this.add(trackSpendingButton);
		
		setBudgetButton = new JButton("Set Budget");
		setBudgetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		setBudgetButton.setLocation(10, 120);
		setBudgetButton.setSize(Constants.OPTIONS_BUTTON_WIDTH, Constants.OPTIONS_BUTTON_HEIGHT);
		this.add(setBudgetButton);
		
		addExpenseButton = new JButton("Add Expense");
		addExpenseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addExpenseButton.setLocation(10, 230);
		addExpenseButton.setSize(Constants.OPTIONS_BUTTON_WIDTH, Constants.OPTIONS_BUTTON_HEIGHT);
		this.add(addExpenseButton);
		
		createActionListeners();
		
	}
	
	//adding action listeners to the option buttons
	private void createActionListeners() {
		
		addExpenseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.showCard(Constants.NEW_EXPENSE_PANEL_ID);
			}
		});
		
		setBudgetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.showCard(Constants.NEW_BUDGET_PANEL_ID);
			}
		});
		
		trackSpendingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.showCard(Constants.EXPENSE_VISUALIZATION_PANEL_ID);
			}
		});
	}

	

}
