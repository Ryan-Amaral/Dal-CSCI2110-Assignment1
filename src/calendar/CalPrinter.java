package calendar;

import java.util.Scanner; // for user input

/**
 * When run, this program prompts the user for the amount of rows, columns,
 * the year and whether to use full or short month names. The calendar of 
 * these specifications is printed to the console.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: It asks the user for information of the calendar
 * they desire. The user gets to select dimensions, the year, and whether
 * to use long or short month names. All input is validated.
 * 
 * @author Andrew Rau-Chaplin, and Ryan Amaral
 *
 */
public class CalPrinter
{
	
	/**
	 * Prints the calendar of the specified year in the specified dimensions.
	 * This is done by using nested for loops, and printing one line of the 
	 * calendar at a time. First the year is printed, the the first row of
	 * month names, the the day titles, then the first week of the month, 
	 * then the second week of the month...
	 * 
	 * @param year -> The year that the calendar displays.
	 * @param rows -> The amount of rows of months.
	 * @param cols -> The amount of columns of months.
	 * @param isLongNames -> Whether the months are full month names, or 
	 *  short 3-letter names. E.g.('Jan' vs. 'January').
	 */
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
	
	/**
	 * This function asks the user for details about how the user wants
	 * the calendar to be displayed, then displays the calendar as such.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{	
		String input; // temp space used for inputs from user
		Boolean isValid = false; // boolean used to determine if input is valid
		
		// rows and columns of months
		int rows = 3;
		int cols = 4;
		
		int year = 2017; // the year to use
		
		Boolean isFullNames = true; // whether to use full or short month names
		
		System.out.println("Hello, welcome to The Calendar Printer.\n"
				+ "Please enter the amount of rows and columns of months "
				+ "that you want.");

		Scanner scanner = new Scanner(System.in); // to get input
		
		// the pattern that the dimension input must be in
		final String dimensionPattern = "\\d{1,2}(x|,| |X)\\d{1,2}";
		// the pattern for a year (accepts from 0 to 9999)
		final String yearPattern = "\\d{1,4}";
		
		// repeatedly ask for input until it is valid
		while(!isValid){
			System.out.println("Please enter in the form '#,#', or '#x#', "
					+ "or '# #'. Rows and columns must multiply to equal 12:");
			input = scanner.nextLine();
			if(input.matches(dimensionPattern)){
				String tmpStrs[] = input.split("(,|x|X| )");
				try{
					rows = Integer.parseInt(tmpStrs[0]);
					cols = Integer.parseInt(tmpStrs[1]);
					if(rows * cols == 12)
						isValid = true;
					else
						System.out.println("Invalid amount of rows and columns. "
								+ "Please try again.");
				}catch(Exception e){
					System.out.println("An error has occured with your input, "
							+ "please try again.");
				}
			}
			else
				System.out.println("Your input did not match the pattern, "
						+ "please try again.");
		}
		
		isValid = false; // reset validity flag
		
		// dimensions of calendar has been entered, now to get year
		while(!isValid){
			System.out.println("Please enter a year:");
			input = scanner.nextLine();
			if(input.matches(yearPattern)){
				try{
					year = Integer.parseInt(input);
					isValid = true;
				}catch(Exception e){
					System.out.println("An error has occured with your input, "
							+ "please try again.");
				}
			}
			else
				System.out.println("Your input was not valid, please try again.");
		}
		
		// now to see if want full or short month names
		System.out.println("Do you want to use full month names? "
				+ "Enter 'y' for yes, otherwise the calendar will "
				+ "use \nshortened versions of the month names.");
		
		input = scanner.nextLine();
		
		if(input.equals("y") || input.equals("Y"))
			isFullNames = true;
		else
			isFullNames = false;
		
		System.out.println(); // extra blank line
		
		//Test printing a Calendar
		printCalendar(year, rows, cols, isFullNames);
	}
}