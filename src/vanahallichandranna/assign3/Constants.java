/**
 * 
 */
package vanahallichandranna.assign3;

/**
 * @author Sneha
 *
 */
//this class depicts the various constants used
public class Constants {

	static final int WINDOW_WIDTH = 1430;
	static final int WINDOW_HEIGHT = 700;
	
	static final int MAIN_PANEL_HEADER_WIDTH = 1410;
	static final int MAIN_PANEL_HEADER_HEIGHT = 100;
	static final int MAIN_PANEL_HEADER_LOCATIONX = 10;
	static final int MAIN_PANEL_HEADER_LOCATIONY = 0;
	
	
	static final int OPTIONS_PANEL_HEIGHT = WINDOW_HEIGHT - 2*100;
	static final int OPTIONS_PANEL_WIDTH = 150;
	static final int OPTIONS_PANEL_LOCATIONX = 10;
	static final int OPTIONS_PANEL_LOCATIONY = 100;
	static final int OPTIONS_BUTTON_WIDTH = OPTIONS_PANEL_WIDTH - 20;
	static final int OPTIONS_BUTTON_HEIGHT = 100;
	
	static final int NEW_EXPENSE_PANEL_HEIGHT = WINDOW_HEIGHT - 2*100;
	static final int NEW_EXPENSE_PANEL_WIDTH = 500;
	static final int NEW_EXPENSE_PANEL_LOCATIONX = 500;
	static final int NEW_EXPENSE_PANEL_LOCATIONY = 120;
	
	static final int NEW_BUDGET_PANEL_HEIGHT = WINDOW_HEIGHT - 2*100;
	static final int NEW_BUDGET_PANEL_WIDTH = 850;
	static final int NEW_BUDGET_PANEL_LOCATIONX = 400;
	static final int NEW_BUDGET_PANEL_LOCATIONY = 120;
	
	static final int NEW_BUDGET_HEADER_PANEL_HEIGHT = 50;
	static final int NEW_BUDGET_HEADER_PANEL_WIDTH = NEW_BUDGET_PANEL_WIDTH - 2*50;
	static final int NEW_BUDGET_HEADER_PANEL_LOCATIONX = 50;
	static final int NEW_BUDGET_HEADER_PANEL_LOCATIONY = 50;
	
	static final int NEW_BUDGET_ENTRY_PANEL_HEIGHT = 280;
	static final int NEW_BUDGET_ENTRY_PANEL_WIDTH = NEW_BUDGET_PANEL_WIDTH - 2*50;
	static final int NEW_BUDGET_ENTRY_PANEL_LOCATIONX = 50;
	static final int NEW_BUDGET_ENTRY_PANEL_LOCATIONY = NEW_BUDGET_HEADER_PANEL_LOCATIONY + NEW_BUDGET_HEADER_PANEL_HEIGHT + 10;
	
	static final int NEW_BUDGET_BUTTON_PANEL_HEIGHT = 50;
	static final int NEW_BUDGET_BUTTON_PANEL_WIDTH = NEW_BUDGET_PANEL_WIDTH - 2*50;
	static final int NEW_BUDGET_BUTTON_PANEL_LOCATIONX = 50;
	static final int NEW_BUDGET_BUTTON_PANEL_LOCATIONY = NEW_BUDGET_ENTRY_PANEL_LOCATIONY + NEW_BUDGET_ENTRY_PANEL_HEIGHT + 10;
	
	
	static final String NEW_EXPENSE_PANEL_ID = "expensepanel";
	static final String NEW_BUDGET_PANEL_ID = "budgetpanel";
	static final String EXPENSE_VISUALIZATION_PANEL_ID = "visualizationpanel";
	
	static final int EXPENSE_VISUALIZATION_PANEL_WIDTH = 1250;
	static final int EXPENSE_VISUALIZATION_PANEL_HEIGHT = WINDOW_HEIGHT - 2*100;
	
	static final int EXPENSE_DETAILS_PANEL_WIDTH = 400;
	static final int EXPENSE_DETAILS_PANEL_HEIGHT = WINDOW_HEIGHT - 2*100 - 2*10;
	
	
}