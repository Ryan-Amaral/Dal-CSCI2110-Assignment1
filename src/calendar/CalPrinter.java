package calendar;

import java.util.Scanner; // for user input

/**
 * 
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features:
 * 
 * @author Andrew Rau-Chaplin, and Ryan Amaral
 *
 */
public class CalPrinter
{
	
	public static void printCalendar(int year, int rows, int cols, Boolean isLongNames){
		
		if(rows * cols != 12){
			System.out.println("Rows times columns must equal 12! "
					+ "Yours equals " + (rows * cols) + ".");
			System.exit(0);
		}
	
		//Create an array of 12 month objects corresponding to the year
		Month[][] months = new Month[rows][cols];
		
		// populate the array
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				months[row][col] = new Month(year, (row * cols) + col);
			}
		}
		
		//Using the array of months print the calendar one line at a time
		// first print the year
		System.out.println("Calendar for " + year);
		for(int row = 0; row < rows; row++){
			// each month takes 8 lines
			for(int line = 0; line < 8; line++){
				// line 0 prints month titles
				if(line == 0){
					for(int col = 0; col < cols; col++){
						// print month names
						System.out.print(months[row][col].getFittedName(isLongNames) + "   ");
					}
				}
				// line 1 prints days of week
				else if(line == 1){
					for(int col = 0; col < cols; col++){
						// print month names
						System.out.print(" S  M  T  W  T  F  S   ");
					}
				}
				// line 2 to line 7 print week 0 to week 5 of the month
				// the week is line - 2
				else{
					for(int col = 0; col < cols; col++){
						// print month names
						System.out.print(months[row][col].weekString(line - 2) + "   ");
					}
				}
				
				System.out.println(); // go to next line
			}
		}
		
	}
	
	public static void main(String[] args)
	{	
		
		
		//Test printing a Calendar
		printCalendar(2017, 3, 4, true);
	}
}