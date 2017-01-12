package coconuts;

/**
 * Class SailorCoconuts helps to find what amount of sailors and coconuts
 * are valid for the  pirate coconut problem.
 * 
 * 
 * 
 * @author Ryan
 *
 */
public class SailorCoconuts {

	
	/**
	 * Recursively checks whether the given amount of sailors and coconuts
	 * are valid quantities for sailor coconut problem. I would have liked
	 * to have made each of the variables unsigned, but apparently that is
	 * not a thing in Java. Each iteration through...
	 * 
	 * @param sailors -> The total amount of sailors on the island.
	 * @param sailorsSleeping -> The amount of sailors that have not yet
	 *  woken up to mess with the coconuts. Works as the index. Starts at
	 *  sailors - 1 because this function starts with the first sailor 
	 *  being awake and ends when sailorsSleeping == 0.
	 * @param coconuts -> The total amount of coconuts, starts off as the 
	 *  amount before a sailor messes with them.
	 * @return True if the amount of coconuts works for the given amount 
	 *  of sailors.
	 */
	public static boolean testCoconuts(int sailors, int sailorsSleeping, 
			int coconuts){
		
		// this problem never works with one sailor, as the one sailor's
		// share will always be the whole pile.
		if(sailors == 1)
			return false;
		
		// only true with zero sailors if there is one coconut because the
		// monkey needs exactly one coconut
		if(sailors == 0 && coconuts == 1)
			return true;
		else if(sailors == 0)
			return false;
		
		// first time in checks if coconuts is at-least minimum valid value
		if(sailorsSleeping + 1 == sailors
				&& coconuts < Math.pow(sailors, sailors + 1) - sailors + 1)
			return false; // too few coconuts to be valid
		
		// I would put a condition right here to check if the amount of
		// coconuts is equal to the min valid amount, but that would
		// defeat the purpose of question 0)b
		
		coconuts--; // give one coconut to the monkey
		
		// the amount of coconuts that each sailor would get
		int coconutShare = coconuts / sailors;
		
		// if coconuts did not divide evenly
		if(coconutShare * sailors != coconuts)
			return false;
		
		// checks if all sailors have already woken up at some point and 
		// hid some coconuts, so it is over
		if(sailorsSleeping == 0)
			return true;
		
		// time for the next sailor to wake up and be naughty, the sailor 
		// in this iteration of recursion buried his/her coconut share, 
		// so that amount is subtracted from the coconuts for the next sailor
		return testCoconuts(sailors, --sailorsSleeping, coconuts - coconutShare);
	}
	
	
	/**
	 * Uses the equation s^(s+1)-s+1 to find the minimum amount of 
	 * coconuts needed to satisfy the problem with the given amount of 
	 * sailors. I have not proved this equation, however it holds true for
	 * all of the values tested with testCoconuts.
	 * 
	 * @param sailors -> The amount of sailors in the problem.
	 * @return Returns the amount of coconuts that is the minimum
	 *  required amount for the given number of sailors.
	 */
	public static long minValidCoconutsEquation(int sailors){
		if(sailors == 1) // never true with one sailor
			return -1;
		else // otherwise there is a solution
			return (long)Math.pow(sailors, sailors + 1) - sailors + 1;
	}
	
	
	/**
	 * Uses the recursive testCoconuts function to find the smallest 
	 * amount of coconuts that can be used for a valid solution of the
	 * sailor coconut problem. Starts checking at the amount of sailors
	 * + 1, and increments by one.
	 * 
	 * @param sailors -> The amount of sailors in the problem.
	 * @return Returns the amount of coconuts that is the minimum
	 *  required amount for the given number of sailors. This one returns
	 *  an integer as opposed to the other min function because the 
	 *  recursive function only accepts an int amount of coconuts.
	 *  Returns -1 if no solution found.
	 */
	public static int minValidCoconutsIteration(int sailors){
		
		// start checking at sailors + 1
		for(int coconuts = sailors + 1; coconuts < Integer.MAX_VALUE; coconuts++){
			if(SailorCoconuts.testCoconuts(sailors, sailors - 1, coconuts))
				return coconuts;
		}
		
		return -1;
	}
}
