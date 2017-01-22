package coconuts;

/**
 * This class is the driver class for a program which determines validity 
 * of solutions of the sailor coconut problem.
 * 
 * First it shows the minimum amount of required coconuts for a given 
 * amount of sailors using an efficient equation. Then it does the same
 * using the recursive function repeatedly. Then it shows some samples of
 * output for some sailor and coconut values.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: I show that my method gets all of the values that
 * the equation gets, as well as showing some crazy high values of sailors
 * and coconuts. I also came up with a method to find the first n amount
 * of coconuts for each amount of sailors.
 * 
 * @author Ryan Amaral
 *
 */
public class SailorCoconutDriver {

	/**
	 * Runs all test stuff for the SailorCoconutClass.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Minimum coconuts required for the given amount \n"
				+ "of sailors (using equation) (-1 means no solution). \n"
				+ "Overflows long data type after 15 sailors.");
		// prints the minimum amount of coconuts needed for each amount of
		// sailors, only goes to 15 because it overflows long datatype
		for(int s = 0; s < 16; s++)
			System.out.println(s + " sailors requre at-least " 
					+ SailorCoconuts.minValidCoconutsEquation(s) + " coconuts.");
		
		System.out.println();
		
		System.out.println("Minimum coconuts required for the given amount "
				+ "of sailors \n(using equation (returning double))"
				+ "(-1 means no solution). \nOverflows double datatype after "
				+ "142 sailors (says it needs infinity for above this amount).");
		// prints the minimum amount of coconuts needed for each amount of
		// sailors, only goes to 140 because it overflows double datatype
		for(int s = 130; s < 144; s++)
			System.out.println(s + " sailors requre at-least " 
					+ SailorCoconuts.minValidCoconutsEquationDouble(s) + " coconuts.");
		
		System.out.println();
		
		System.out.println("Minimum coconuts required for the given amount "
				+ "of sailors \n(using recursive method repeatedly) "
				+ "(-1 means no solution). \nOverflows int datatype after "
				+ "8 sailors.");
		// prints the minimum amount of coconuts needed for each amount of
		// sailors as obtained from iteratively accessing the recursive 
		// function, only goes to 8 as int overflows
		for(int s = 0; s < 9; s++)
			System.out.println(s + " sailors requre at-least " 
					+ SailorCoconuts.minValidCoconutsIteration(s) + " coconuts.");
		
		
		
		System.out.println("\nSome sample values below:\n");
		int sailors = 2;
		int[] coconutAmounts = {6,7,8,14,15,16,22,23,31,63};
		
		Boolean isGoodValue;
		
		for(int i = 0; i < coconutAmounts.length; i++){
			isGoodValue = 
					SailorCoconuts.testCoconuts(sailors, sailors - 1, coconutAmounts[i]);
			
			if(isGoodValue)
				System.out.println("SUCCESS!!! " + sailors + " sailors and " 
						+ coconutAmounts[i] + " coconuts is valid!" );
			else
				System.out.println("FAILURE!!! " + sailors + " sailors and " 
						+ coconutAmounts[i] + " coconuts is not valid!" );
		}
		
		System.out.println();
		
		sailors = 3;
		coconutAmounts = new int[]{78,79,160,322,645,646};
		
		for(int i = 0; i < coconutAmounts.length; i++){
			isGoodValue = 
					SailorCoconuts.testCoconuts(sailors, sailors - 1, coconutAmounts[i]);
			
			if(isGoodValue)
				System.out.println("SUCCESS!!! " + sailors + " sailors and " 
						+ coconutAmounts[i] + " coconuts is valid!" );
			else
				System.out.println("FAILURE!!! " + sailors + " sailors and " 
						+ coconutAmounts[i] + " coconuts is not valid!" );
		}
		
		System.out.println();
		
		sailors = 4;
		coconutAmounts = new int[]{1021,2045,4093,8189,8190, 1};
		
		for(int i = 0; i < coconutAmounts.length; i++){
			isGoodValue = 
					SailorCoconuts.testCoconuts(sailors, sailors - 1, coconutAmounts[i]);
			
			if(isGoodValue)
				System.out.println("SUCCESS!!! " + sailors + " sailors and " 
						+ coconutAmounts[i] + " coconuts is valid!" );
			else
				System.out.println("FAILURE!!! " + sailors + " sailors and " 
						+ coconutAmounts[i] + " coconuts is not valid!" );
		}
		
		
		System.out.println("\nThe following shows the first 5 valid amount of \n"
				+ "coconuts for 2 to 8 pirates.");
		
		int curCoconutAmount;
		
		// This nested for loop uses a formula which shows the first 5 amount 
		// of coconuts for 2 to 8 pirates.
		// This is a noteworthy part.
		for(int s = 2; s < 9; s++){
			System.out.println();
			curCoconutAmount = (int)SailorCoconuts.minValidCoconutsEquation(s);
			for(int i = 0; i < 5; i++){
				
				if(i > 0)
					curCoconutAmount = curCoconutAmount * 2 + s - 1;
				
				isGoodValue = 
						SailorCoconuts.testCoconuts(s, s - 1, curCoconutAmount);
				
				if(isGoodValue)
					System.out.println("SUCCESS!!! " + s + " sailors and " 
							+ curCoconutAmount + " coconuts is valid!" );
				else
					System.out.println("FAILURE!!! " + s + " sailors and " 
							+ curCoconutAmount + " coconuts is not valid!" );
			}
		}
		
	}

}
