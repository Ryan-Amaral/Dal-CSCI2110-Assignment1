package coconuts;

/**
 * This class is the driver class for a program which determines validity 
 * of solutions of the sailor coconut problem.
 * 
 * 
 * @author Ryan
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
		
		
		
		System.out.println("");
		int sailors = 5;
		int coconuts = 1021;
		
		Boolean isGoodValue;
		isGoodValue = 
				SailorCoconuts.testCoconuts(sailors, sailors - 1, coconuts);
		
		if(isGoodValue)
			System.out.println("SUCCESS!!! " + sailors + " sailors and " 
					+ coconuts + " coconuts is valid!" );
		else
			System.out.println("FAILURE!!! " + sailors + " sailors and " 
					+ coconuts + " coconuts is not valid!" );
	}

}
