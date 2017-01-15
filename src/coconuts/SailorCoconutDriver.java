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
 * @author Ryan Amaral
 *
 */
public class SailorCoconutDriver {

	public static void main(String[] args) {
		
		System.out.println("Minimum coconuts required for the given amount "
				+ "of sailors (using equation)");
		// prints the minimum amount of coconuts needed for each amount of
		// sailors, only goes to 15 because it overflows long datatype
		for(int s = 0; s < 16; s++)
			System.out.println(s + " sailors requre at-least " 
					+ SailorCoconuts.minValidCoconutsEquation(s) + " coconuts.");
		
		System.out.println();
		
		System.out.println("Minimum coconuts required for the given amount "
				+ "of sailors (using recursive method repeatedly)");
		// prints the minimum amount of coconuts needed for each amount of
		// sailors as obtained from iteratively accessing the recursive 
		// function, only goes to 8 as int overflows
		for(int s = 0; s < 9; s++)
			System.out.println(s + " sailors requre at-least " 
					+ SailorCoconuts.minValidCoconutsIteration(s) + " coconuts.");
		
		
		
		System.out.println("\nSome sample values below:");
		int sailors = 2;
		int[] coconutAmounts = {6,7,8,9,14,15,16,17,22,23};
		
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
	}

}
