package coconuts;

/**
 * This class is the driver class for a program which determines validity 
 * 	of solutions of the sailor coconut problem.
 * 
 * 
 * @author Ryan
 *
 */
public class SailorCoconutDriver {

	public static void main(String[] args) {
		
		int sailors = 5;
		int coconuts = 1021;
		
		Boolean isGoodValue;
		isGoodValue = SailorCoconuts.testCoconuts(sailors, sailors - 1, coconuts);
		
		if(isGoodValue)
			System.out.println("SUCCESS!!! " + sailors + " sailors and " + coconuts + " coconuts is valid!" );
		else
			System.out.println("FAILURE!!! " + sailors + " sailors and " + coconuts + " coconuts is not valid!" );
	}

}
