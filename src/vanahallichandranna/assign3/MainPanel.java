/**
 * 
 */
package vanahallichandranna.assign3;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * @author Sneha
 *
 */
public class MainPanel extends JPanel {
	private JPanel headerPanel;
	private OptionsPanel optionsPanel;
	private NewExpensePanel newExpensePanel;
	private ExpenseVisualizationPanel expenseVisualizationPanel;
	private NewBudgetPanel newBudgetPanel;
	private CardLayout displayLayout;
	private JPanel cardPanel;
	private HashMap<String, JPanel> cardElements;

	/**
	 * 
	 */
	//Main panel contains all the other individual panels
	public MainPanel(Data data) {
		this.setLayout(null);
		setBackground(new Color( 169, 221, 217));
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		optionsPanel = new OptionsPanel(this);
		this.add(optionsPanel);
		
		headerPanel = createExpenseTrackerHeaderPanel();
		this.add(headerPanel);
		
		newExpensePanel = new NewExpensePanel(data);
		expenseVisualizationPanel = new ExpenseVisualizationPanel(data);
		newBudgetPanel = new NewBudgetPanel(data);
		
		this.add(newExpensePanel);
		this.add(expenseVisualizationPanel);
		this.add(newBudgetPanel);
		
		//different panels are added to cardElements which are switched based on the action
		cardElements = new HashMap<String, JPanel>();
		cardElements.put(Constants.NEW_EXPENSE_PANEL_ID, newExpensePanel);
		cardElements.put(Constants.NEW_BUDGET_PANEL_ID, newBudgetPanel);
		cardElements.put(Constants.EXPENSE_VISUALIZATION_PANEL_ID, expenseVisualizationPanel);
		
		hideAllCards();
	}
	
	//creates the expense tracker header panel 
	private JPanel createExpenseTrackerHeaderPanel() {
		headerPanel = new JPanel();
		JLabel expenseTrackerLabel = new JLabel("Expense Tracker", SwingConstants.CENTER);
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
	    Font newFont = myFont.deriveFont(46F);
	    expenseTrackerLabel.setFont(newFont);
	    expenseTrackerLabel.setVisible(true);
		headerPanel.add(expenseTrackerLabel);
		headerPanel.setBackground(new Color( 35, 181, 175));
		headerPanel.setLocation(Constants.MAIN_PANEL_HEADER_LOCATIONX, Constants.MAIN_PANEL_HEADER_LOCATIONY);
		headerPanel.setSize(Constants.MAIN_PANEL_HEADER_WIDTH, Constants.MAIN_PANEL_HEADER_HEIGHT);
		return headerPanel;
	}
	
	//Displays a particular card
	public void showCard(String cardName) {
		System.out.println("Showing " + cardName);
		JPanel panel = cardElements.get(cardName);
		hideAllCards();
		panel.setVisible(true);
	}
	
	//hides all the cards in the cardElements
	public void hideAllCards() {
		for( JPanel panel: cardElements.values() ) {
			panel.setVisible(false);
		}
	}
}
