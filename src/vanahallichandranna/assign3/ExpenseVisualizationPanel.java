/**
 * 
 */
package vanahallichandranna.assign3;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vanahallichandranna.assign3.bubblechart.BubbleChart;
import vanahallichandranna.assign3.bubblechart.BubbleData;
import vanahallichandranna.assign3.bubblechart.DataSource;

/**
 * @author Sneha
 *
 */
public class ExpenseVisualizationPanel extends JPanel implements DataSource {
	private Data data;
	private JPanel expenseDetailsPanel;
	private JPanel visualizationPanel;
	
	private DatePanel startDatePanel;
	private DatePanel endDatePanel;
	private BubbleChart chart;
	
    /**
	 * 
	 */
	//this panels both the expense details panel and the graphical repretation panel
	public ExpenseVisualizationPanel(Data d) {
		setLayout(null);
		this.setLocation(170, 100);
		setBackground(new Color( 169, 221, 217));
		this.setSize(Constants.EXPENSE_VISUALIZATION_PANEL_WIDTH, Constants.EXPENSE_VISUALIZATION_PANEL_HEIGHT);
		data = d;
		expenseDetailsPanel = new JPanel();
		visualizationPanel = new JPanel();
		this.add(createExpenseDetailsPanel());
		this.add(createVisualizationPanel());
		
		this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				//createVisualizationPanel();
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	//creates the Expense Details Panel
	private JPanel createExpenseDetailsPanel() {
		expenseDetailsPanel.setLayout(null);
		expenseDetailsPanel.setLocation(10, 10);
		expenseDetailsPanel.setBackground(new Color( 35, 181, 175));
		expenseDetailsPanel.setSize(Constants.EXPENSE_DETAILS_PANEL_WIDTH, Constants.EXPENSE_DETAILS_PANEL_HEIGHT);
		expenseDetailsPanel.setVisible(true);
		
		JPanel headerPanel = new JPanel();
		JLabel trackSpendingLabel = new JLabel("Track Spending", SwingConstants.CENTER);
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
	    Font newFont = myFont.deriveFont(36F);
	    trackSpendingLabel.setFont(newFont);
	    headerPanel.add(trackSpendingLabel);
	    headerPanel.setLocation(10, 10);
	    headerPanel.setSize(Constants.EXPENSE_DETAILS_PANEL_WIDTH - 2*10, 50);
	    headerPanel.setVisible(true);
	    expenseDetailsPanel.add(headerPanel);
	    
	    //catetgory label
	    JLabel categoryLabel = new JLabel("Category");
	    categoryLabel.setLocation(80, 70);
	    categoryLabel.setSize(70, 50);
	    categoryLabel.setVisible(true);
	    expenseDetailsPanel.add(categoryLabel);
	    
	    //category ComboBox
	    String[] categories = new String[] {"All", "Food", "Rent", "Studies", "Entertainment", "Fuel"};
	    JComboBox<String> categoriesComboBox = new JComboBox<String>(categories);
	    categoriesComboBox.setLocation(160, 70);
	    categoriesComboBox.setSize(100, 50);
	    categoriesComboBox.setVisible(true);
	    expenseDetailsPanel.add(categoriesComboBox);
	    
	    JLabel fromLabel = new JLabel("From : ");
		fromLabel.setLocation(80, 130);
		fromLabel.setSize(50, 50);
		fromLabel.setVisible(true);
		expenseDetailsPanel.add(fromLabel);
		
		//start date panel
		startDatePanel = new DatePanel();
		startDatePanel.setLocation(140, 130);
		startDatePanel.setSize(220, 50);
		expenseDetailsPanel.add(startDatePanel);
		
		JLabel toLabel = new JLabel("To : ");
		toLabel.setLocation(100, 190);
		toLabel.setSize(40, 50);
		toLabel.setVisible(true);
		expenseDetailsPanel.add(toLabel);

		//end date panel
		endDatePanel = new DatePanel();
		endDatePanel.setLocation(140, 190);
		endDatePanel.setSize(220, 50);
		expenseDetailsPanel.add(endDatePanel);
	    
		//track button
	    JButton trackButton = new JButton("Track");
	    trackButton.setLocation(150, 250);
	    trackButton.setSize(100, 50);
	    trackButton.setVisible(true);
	    expenseDetailsPanel.add(trackButton);

	    JLabel allBudgetLabel = new JLabel("Overall Budget : ");
	    JLabel categoryBudgetLabel = new JLabel("Category budget : ");
	    JLabel allBudgetAmountLabel = new JLabel();
	    JLabel categoryBudgetAmountLabel = new JLabel();
	    JLabel expenseLabel = new JLabel("Amount spent : ");
	    JLabel amountLabel = new JLabel();
	   
	    expenseDetailsPanel.add(allBudgetLabel);
	    expenseDetailsPanel.add(categoryBudgetLabel);
	    expenseDetailsPanel.add(allBudgetAmountLabel);
	    expenseDetailsPanel.add(categoryBudgetAmountLabel);
	    expenseDetailsPanel.add(expenseLabel);
	    expenseDetailsPanel.add(amountLabel);
			        	    
	    //this action listener will display the budget set details and renders the 
	    //graphical representation based on the category and the period details entered
	    trackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String,BudgetPerCategory> budgets = data.getBudgets();
				
				Date startDate = startDatePanel.getDate(DatePanel.Time.START_OF_DAY);
				Date endDate = endDatePanel.getDate(DatePanel.Time.END_OF_DAY);
				
				
				BudgetPeriod budgetPeriod = new BudgetPeriod(startDate, endDate);
				
				
				BudgetPerCategory budgetPerCategory = budgets.get(categoriesComboBox.getSelectedItem().toString());
				if (budgetPerCategory == null) {
					categoryBudgetAmountLabel.setText("Not set");
				} else {
					Budget budget = budgetPerCategory.getBudget(budgetPeriod);
					if (budget == null) {
						categoryBudgetAmountLabel.setText("Budget not set");
					} else {
						categoryBudgetAmountLabel.setText(String.valueOf(budget.getAmount()));
					}				
				}
				
				BudgetPerCategory allBudgetPerCategory = budgets.get("All");
				if (allBudgetPerCategory == null) {
					allBudgetAmountLabel.setText("Not set");
				} else {
					Budget allBudget = allBudgetPerCategory.getBudget(budgetPeriod);
					if(allBudget == null) {
						allBudgetAmountLabel.setText("Not set");
					} else {
						allBudgetAmountLabel.setText(Double.toString(allBudget.getAmount()));
					}
				}
		
				
				allBudgetLabel.setLocation(10, 300);
				allBudgetLabel.setSize(100, 50);
				allBudgetLabel.setVisible(true);
			    				
			    allBudgetAmountLabel.setLocation(110, 300);
			    allBudgetAmountLabel.setSize(100, 50);
			    allBudgetAmountLabel.setVisible(true);
				
				categoryBudgetLabel.setLocation(10, 350);
				categoryBudgetLabel.setSize(100, 50);
				categoryBudgetLabel.setVisible(true);
			    
				categoryBudgetAmountLabel.setLocation(110, 350);
				categoryBudgetAmountLabel.setSize(100, 50);
				categoryBudgetAmountLabel.setVisible(true);
			    
				expenseLabel.setLocation(10, 400);
			    expenseLabel.setSize(100, 50);
			    expenseLabel.setVisible(true);
			    
			    double totalExpense = getTotalExpense(startDate, endDate);
			    
			    amountLabel.setText(String.valueOf(totalExpense));
			    amountLabel.setLocation(110, 400);
			    amountLabel.setSize(100, 50);
			    amountLabel.setVisible(true);
			    
			    //renders the bubble chart for the data
			    updateChart();			    
			}
		});
	    return expenseDetailsPanel;
	}
	
	//gets the total expense in the given start and end date
	private double getTotalExpense(Date startDate, Date endDate) {
		double totalExpense = 0;
		ArrayList<Expense> expenses = data.getExpenses();
		for (Expense expense : expenses) {
			if (expense.getDate().after(startDate)
					&& expense.getDate().before(endDate)) {
				totalExpense = totalExpense + expense.getExpenseAmount();
			}
		}
		return totalExpense;
	}
	
	//refreshes the statistics chart
	private void updateChart() {
		chart.refreshData();
		chart.repaint();
	}
	
	//creates the statistics visualization panel
	public JPanel createVisualizationPanel() {	
		chart = new BubbleChart(this);
		chart.setSize(760, 460);
		chart.setLocation(20, 10);
		chart.setVisible(true);
		visualizationPanel.setLayout(null);
		visualizationPanel.setSize(800, 480);
		visualizationPanel.setLocation(430, 10);
		visualizationPanel.add(chart);
		visualizationPanel.setBackground(Color.white);
		visualizationPanel.setVisible(true);
		return visualizationPanel;
	}
	
	//gets the data necessary to draw the graphical representation
	@Override
	public ArrayList<BubbleData> getBubbleData() {
		ArrayList<BubbleData> chartData = new ArrayList<BubbleData>();
		String[] categories = new String[] {"Food", "Rent", "Studies", "Entertainment", "Fuel"};
	
		Date startDate = startDatePanel.getDate(DatePanel.Time.START_OF_DAY);
		Date endDate = endDatePanel.getDate(DatePanel.Time.END_OF_DAY);
		BudgetPeriod period = new BudgetPeriod(startDate, endDate);
		
		double expense = getTotalExpense(startDate, endDate);
		Budget budget = data.getBudget("All", period);
		double budgetAmount = 0;
		if(budget != null) {
			budgetAmount = budget.getAmount();
		}
		BubbleData d = new BubbleData(budgetAmount, expense, "All");
		chartData.add(d);
		
		for(String category: categories) {
			budget = data.getBudget(category, period);
			expense = data.getExpense(category, period);
			budgetAmount = 0;
			if(budget != null) {
				budgetAmount = budget.getAmount();
			}
			d = new BubbleData(budgetAmount, expense, category);
			chartData.add(d);
		}
		
		return chartData;
	}	
}
