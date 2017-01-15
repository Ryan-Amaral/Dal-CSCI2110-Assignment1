package calendar;

import java.util.*;


/**
 * This class stores information of a single month, it contains some 
 * functionality for retrieval of this information in a way that is
 * relevant to a calendar program. Such as storing days in a 2d array.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: Month names are returned fitted in the middle if 
 * retrieved from the getFittedName method. I added full month names so
 * the user has the option to use them if desired.
 * 
 * @author Andrew Rau-Chaplin, some additions by Ryan Amaral
 *
 */
public class Month
{
	private String name;
	private String nameLong; // the full name of month
	private int[][] days;
	private int daysInMonth;
	private int firstDay;
	private final String[] monthNames ={"Jan","Feb","Mar","Apr","May",
			"Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private final String[] monthNamesLong ={"January","February","March",
			"April","May", "June","July","August","September","October",
			"November","December"};
	private int[] monthLengths = {31,28,31,30,31,30,31,31,30,31,30,31};
	private final int weeksInMonth = 6;
	private final int daysInWeek = 7;

	/**
	 * @return Returns the short 3-letter name of the month.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return Returns the full name of the month.
	 */
	public String getNameLong(){
		return nameLong;
	}
	
	/**
	 * Takes the selected month name and returns it fitted to the middle
	 * of 20 chars.
	 * 
	 * @param isLongVersion -> If true, returns the long version of the 
	 *  month name
	 * @return Returns the month name formatted to fit in the middle of 
	 *  20 chars.
	 */
	public String getFittedName(Boolean isLongVersion){
		String monthName = getName(); // default to short
		String formattedMonthName = ""; // the string to return
		// switch to long name if selected
		if(isLongVersion == true)
			monthName = getNameLong();
		
		// the amount of spaces to put on either side of month
		int spaceBorderLength = (20 - monthName.length()) / 2;
		
		for(int i = 0; i < spaceBorderLength; i++){
			formattedMonthName += " "; // put spaces
		}
		formattedMonthName += monthName; // month name in middle
		for(int i = 0; i < spaceBorderLength; i++){
			formattedMonthName += " "; // ending spaces
		}
		
		// put same amount of spaces on both sides
		if((20 - monthName.length()) % 2 != 0){
			
			formattedMonthName += " "; // one extra space on right
		}
		
		return formattedMonthName;
	}
	
	/**
	 * Creates a month object from a specific month in a specific year.
	 * It uses the GregorianCalendar class to get information about the
	 * specific month. It takes into account leap years and also stores
	 * all of the days in the month in a 2d array in the format [year]
	 * [day of week].
	 * 
	 * @param year -> The year that the month is from.
	 * @param monthNum -> The number month of the year.
	 */
	public Month(int year, int monthNum){
		//GregorianCalendar object used to find what day the month starts on
		GregorianCalendar c = new GregorianCalendar(year, monthNum, 1);
		int currentDay = 1;

		// Set the name of the month
		name = monthNames[monthNum];
		nameLong = monthNamesLong[monthNum];

		// reset the length of February for leap years
		if (c.isLeapYear(year))
			monthLengths[1] = 29;  
		daysInMonth = monthLengths[monthNum];

		// What day of the week does the month start on?
		firstDay = c.get(Calendar.DAY_OF_WEEK)-1; 

		// Create an 2d array representing 6 weeks each of 7 days each
		days = new int[weeksInMonth][daysInWeek];  

		// Initialize the days array for this month
		// if day 0, that means it is not a day in the week.
		for (int week = 0; week < weeksInMonth; week++) {
			for (int day = 0; day < 7; day++) {
				if (week == 0 && day < firstDay) {
					days[week][day] = 0;
				} else if (currentDay > daysInMonth) {
					days[week][day] = 0;
				} else
					days[week][day] = currentDay++;
			}
		}
	}

/*  Not needed for my purposes
	public static void main(String args[]){
		Month m = new Month(1999,3);
		
		// Without first creating a toString method for months this will
		// not be very informative!
		System.out.println(m); 

	}*/
	
	/**
	 * Returns a string representing the days in the chosen week. each of
	 * the days in the week is 3 characters long, even if it is not a day
	 * in the month so that things are evenly spaced.
	 * 
	 * @param week -> The week in the month
	 * @return Returns a string representing the days in the chosen week.
	 */
	public String weekString(int week){
		String weekString = "";
		// for each day of week
		for(int day = 0; day < 7; day++){
			// not a day in this month
			if(days[week][day] == 0){
				weekString+= "   "; // just blank
			}
			// single digit day of the month
			else if(((Integer)days[week][day]).toString().length() == 1){
				weekString+= " " + days[week][day] + " ";
			}
			// double digit day of the month
			else if(((Integer)days[week][day]).toString().length() == 2){
				weekString+= days[week][day] + " ";
			}
		}
		
		// chop off extra blank at end
		weekString = weekString.substring(0, weekString.length() - 1);
		
		return weekString;
	}

}