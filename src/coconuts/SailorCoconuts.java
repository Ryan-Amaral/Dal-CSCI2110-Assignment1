package coconuts;

/**
 * Class SailorCoconuts helps to find what amount of sailors and coconuts
 * are valid for the sailor coconut problem. Contains functions both to
 * find a minimum amount of coconuts for a given amount of sailors and
 * a function that tests if any arbitrary values are valid.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: There are two functions that find the minimum 
 * amount of coconuts using a equation which is very efficient. If these 
 * functions were to be used in the recursive function to check if a value
 * is valid on the first round through, it would speed things up 
 * significantly. I of course did not include this, as it would defeat the
 * purpose of the assignment.
 * 
 * @author Ryan Amaral
 *
 */
public class SailorCoconuts {

	
	/**
	 * Recursively checks whether the given amount of sailors and coconuts
	 * are valid quantities for sailor coconut problem. I would have liked
	 * to have made each of the variables unsigned, but apparently that is
	 * not a thing in Java. 
	 * 
	 * Each iteration through the current sailor will split the coconuts 
	 * evenly for each sailor, and there should be one left, which is 
	 * given to a monkey. Then the sailor buries his/her pile and puts 
	 * the rest of the coconuts back together. The rest of the sailors 
	 * do the same on their own turns. After all sailors have done this,
	 * there should be enough coconuts to evenly split among them with
	 * exactly one left over for the monkey. If any of this is not the 
	 * case, the function returns false.
	 * 
	 * @param sailors -> The total amount of sailors on the island.
	 * @param sailorsSleeping -> The amount of sailors that have not yet
	 *  woken up to mess with the coconuts. Works as the index. Starts at
	 *  sailors - 1 because this function starts with the first sailor 
	 *  being awake and ends when sailorsSleeping == -1, which signifies
	 *  when all of the sailors have woken up.
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
		
		/* NOTEABLE FEATURE RIGHT HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * This is only disabled to show that the recursive method does not 
		 * allow too low values, otherwise it would defeat the purpose of
		 * 0)b.
		// first time in checks if coconuts is at-least minimum valid value
		if(sailorsSleeping + 1 == sailors
				&& coconuts < SailorCoconuts.minValidCoconutsEquation(sailors))
			return false; // too few coconuts to be valid*/
		
		// I would put a condition right here to check if the amount of
		// coconuts is equal to the min valid amount, but that would
		// defeat the purpose of question 0)b
		
		// the amount of coconuts that each sailor would get
		int coconutShare = coconuts / sailors;
		
		// after all sailors have already woken up and hid theirs
		if(sailorsSleeping == -1){
			// if all coconuts are gone next round
			if(coconuts - (sailors * coconutShare) - 1 == 0){
				return true;
			}
			else{
				return false;
			}
		}
		// the current sailor doing his/her work
		else{
			// coconuts could not be divided among the sailors
			if(coconutShare == 0)
				return false;
			
			// the amount of coconuts left over after being split by the sailors
			int leftOver = coconuts - (coconutShare * sailors);
			
			// monkey did not get share, return false
			if(leftOver != 1)
				return false;
			
			// subract the sailor's buried pile and the monkey's one coconut.
			coconuts = coconuts - coconutShare - 1;
		}
		
		// time for the next sailor to wake up and be naughty
		return testCoconuts(sailors, --sailorsSleeping, coconuts);
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
	 * Uses the equation s^(s+1)-s+1 to find the minimum amount of 
	 * coconuts needed to satisfy the problem with the given amount of 
	 * sailors. I have not proved this equation, however it holds true for
	 * all of the values tested with testCoconuts. Just like
	 * minValidCoconutsEquation except this returns a double to show
	 * higher values.
	 * 
	 * @param sailors -> The amount of sailors in the problem.
	 * @return Returns the amount of coconuts that is the minimum
	 *  required amount for the given number of sailors.
	 */
	public static double minValidCoconutsEquationDouble(int sailors){
		if(sailors == 1) // never true with one sailor
			return -1;
		else // otherwise there is a solution
			return Math.pow(sailors, sailors + 1) - sailors + 1;
	}
	
	
	/**
	 * Uses the recursive testCoconuts function to find the smallest 
	 * amount of coconuts that can be used for a valid solution of the
	 * sailor coconut problem. Starts checking at the amount of sailors
	 * + 1, and increments by one.
	 * 
	 * @param sailors -> The amount of sailors in the problem.
	 * @return Returns the amount of coconuts that is the minimum
	 *  required amount for the given number of sailors.
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
