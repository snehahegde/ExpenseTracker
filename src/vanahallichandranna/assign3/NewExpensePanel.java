/**
 * 
 */
package vanahallichandranna.assign3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * @author Sneha
 *
 */
public class NewExpensePanel extends JPanel {

	private JPanel headerPanel;
	private JPanel entryPanel;
	private JLabel addExpenseLabel;
	private JLabel categoryLabel;
	private JLabel expenseLabel;
	private JLabel dateLabel;
	private JTextField amountField;
	private DatePanel datePanel;
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton cancelButton; 
	private String[] categories = new String[] {"Food", "Rent", "Studies", "Entertainment", "Fuel"};
	private JComboBox<String> categoriesComboBox;
	private Data data;
	
	
	/**
	 * 
	 */
	//expense panel to enter new expense
	public NewExpensePanel(Data d) {
		data = d;
		setLayout(null);
		//setSize(Constants.OPTIONS_PANEL_WIDTH, Constants.OPTIONS_PANEL_HEIGHT);
		this.setLocation(Constants.NEW_EXPENSE_PANEL_LOCATIONX, Constants.NEW_EXPENSE_PANEL_LOCATIONY);
		setBackground(new Color( 35, 181, 175));
		this.setSize(Constants.NEW_EXPENSE_PANEL_WIDTH, Constants.NEW_EXPENSE_PANEL_HEIGHT);
		createHeaderPanel();
		createEntryPanel();
		createButtonPanel();
	}
	
	//creates a header for the expense panel
	private void createHeaderPanel() {
		headerPanel  = new JPanel();
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
	    Font newFont = myFont.deriveFont(48F);
		addExpenseLabel = new JLabel("Add Expense", SwingConstants.CENTER);
		addExpenseLabel.setFont(newFont);
		headerPanel.add(addExpenseLabel);
		headerPanel.setLocation(50, 50);
		headerPanel.setSize(Constants.NEW_EXPENSE_PANEL_WIDTH - 2*50, 75);
		this.add(headerPanel);
	}
	
	//user entry panel
	private void createEntryPanel() {
		entryPanel = new JPanel();
		entryPanel.setLocation(50, 150);
		entryPanel.setSize(Constants.NEW_EXPENSE_PANEL_WIDTH - 2*50, 225);
		entryPanel.setLayout(null);
				
		JPanel categoryPanel = new JPanel();
		categoryLabel = new JLabel("Category : ");
		categoryPanel.add(categoryLabel);
		categoriesComboBox = new JComboBox<String>(categories);
		categoryPanel.add(categoriesComboBox);
		categoryPanel.setLocation(10, 10);
		categoryPanel.setSize(Constants.NEW_EXPENSE_PANEL_WIDTH - 2*50 - 2*10,60);
		entryPanel.add(categoryPanel);
				
		JPanel expensePanel = new JPanel();
		expenseLabel = new JLabel("Expense : ");
		expensePanel.add(expenseLabel);
		amountField = new JTextField(5);
		expensePanel.add(amountField);
		
		expensePanel.setLocation(10, 80);
		expensePanel.setSize(Constants.NEW_EXPENSE_PANEL_WIDTH - 2*50 - 2*10,60);
		entryPanel.add(expensePanel);
		
		dateLabel = new JLabel("Date : ");
		dateLabel.setLocation(20, 150);
		dateLabel.setSize(50, 50);
		entryPanel.add(dateLabel);
		
		//creates a date panel
		datePanel = new DatePanel();
		datePanel.setLocation(70, 160);
		datePanel.setSize(300,60);
		entryPanel.add(datePanel);		
		
		this.add(entryPanel);		
	}
	
	//creates the add and cancel buttons
	private void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLocation(50, 400);
		buttonPanel.setSize(Constants.NEW_EXPENSE_PANEL_WIDTH - 2*50,50);
		buttonPanel.setLayout(null);
		
		addButton = new JButton("Add");
		addButton.setLocation(50, 10);
		addButton.setSize(130,30);	
		buttonPanel.add(addButton);
		
		cancelButton = new JButton("Cancel");
		buttonPanel.add(cancelButton);
		cancelButton.setLocation(220, 10);
		cancelButton.setSize(130,30);	
		
		this.add(buttonPanel);	
		
		//the new amount spent for a particular category and date is added
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Expense expense = new Expense();
				String categorySelected = (String)categoriesComboBox.getSelectedItem();
				expense.setCategory(categorySelected);
				expense.setExpenseAmount(Double.parseDouble(amountField.getText()));
				System.out.println(expense.getExpenseAmount());
				expense.setDate(datePanel.getDate(DatePanel.Time.CURRENT_TIME));
				data.setExpense(expense);				
			}
		});
	}
	
}
