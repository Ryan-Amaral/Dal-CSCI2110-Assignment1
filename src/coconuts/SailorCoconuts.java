package coconuts;

/**
 * Class SailorCoconuts helps to find what amount of sailors and coconuts
 * 	are valid for the  pirate coconut problem.
 * 
 * 
 * 
 * @author Ryan
 *
 */
public class SailorCoconuts {

	
	/**
	 * Recursively checks whether the given amount of sailors and coconuts
	 * 	are valid quantities for sailor coconut problem. Each iteration 
	 * 	through...
	 * 
	 * @param sailors -> The total amount of sailors on the island.
	 * @param sailorsSleeping -> The amount of sailors that have not yet
	 * 	woken up to mess with the coconuts. Works as the index. Starts at
	 * 	sailors - 1 because this function starts with the first sailor 
	 * 	being awake and ends when sailorsSleeping == 0.
	 * @param coconuts -> The total amount of coconuts, starts off as the 
	 * 	amount before a sailor messes with them.
	 * @return true if the amount of coconuts works for the given amount 
	 * 	of sailors.
	 */
	public static boolean testCoconuts(int sailors, int sailorsSleeping, 
			int coconuts){
		
		// less than one sailor could be assumed to be always true or 
		//	always false (because of divide by 0 being ambiguous) if there
		//	is at-least one coconut, I just assume it to always be true
		if(sailors < 1 && coconuts > 0)
			return true;
		
		// first time in checks if coconuts is at-least minimum valid value
		if(sailorsSleeping + 1 == sailors
				&& coconuts < Math.pow(sailors, sailors + 1) - sailors + 1)
			return false; // too few coconuts to be valid
		
		coconuts--; // give one coconut to the monkey
		
		// the amount of coconuts that each sailor would get
		int coconutShare = coconuts / sailors;
		
		// if coconuts did not divide evenly
		if(coconutShare * sailors != coconuts)
			return false;
		
		// checks if all sailors have already woken up at some point and 
		//	hid some coconuts, so it is over
		if(sailorsSleeping == 0)
			return true;
		
		// time for the next sailor to wake up and be naughty, the sailor 
		//	in this iteration of recursion buried his/her coconut share, 
		//	so that amount is subtracted from the coconuts for the next sailor
		return testCoconuts(sailors, --sailorsSleeping, coconuts - coconutShare);
	}
}
