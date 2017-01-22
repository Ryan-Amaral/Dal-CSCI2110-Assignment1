package flights;


/**
 * This is the driver file for the flight booking program. In this test, I
 * create a sort of dialogue of a flight worker making mistakes and fixing
 * them with the system.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: I tried to make it like a somewhat realistic 
 * situation and showed off some of the features like auto points correction
 * and regex validation of departure entry.
 * 
 * @author Ryan Amaral
 *
 */
public class TestTicket {

	/**
	 * This method tests all of the functionality of the whole flights 
	 * system. It highlights some of the special features such as automatic
	 * points correction and regex validation.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		Customer customer1 = new Customer("Ryan", "123 Fake Street", 328653);
		Customer customer2 = new Customer("Bob", "321 Real Street", 23435);
		
		Flight flight1 = new Flight(128, "Washington", "Lisbon", "02/02/2017 08:00 AM");
		Flight flight2 = new Flight(643, "Athens", "Cape Town", "01/20/2017 03:00 AM");
		
		AirlineTicket ticket1 = new AirlineTicket(customer1, flight1, 589.77);

		System.out.println("The following is a ticket:");
		System.out.println(ticket1.toString());
		
		System.out.println("\nThis is the info of that passenger:");
		System.out.println(customer1.toString());
		
		System.out.println("\nOops, that is the wrong passenger, better change that:");
		ticket1.setPassenger(customer2);
		System.out.println(ticket1.toString());
		
		System.out.println("\nOh wait, the flight is supposed to be PM not AM:");
		ticket1.getFlight().setDeparture("02/02/2017 8:00 PM");
		System.out.println(ticket1.toString());
		
		System.out.println("\nThe following is the info on the passenger who bought this ticket:");
		System.out.println(ticket1.getPassenger().toString());
		
		System.out.println("\nThis is the information on the other customer:");
		System.out.println(customer1.toString());
		
		System.out.println("\nThis advanced system automatically dealt with the points \n"
				+ "appropriately when the passenger on the ticket changed\n\n"
				+ "I just realized that the passengers name is Schlog, not Bob, "
				+ "now to change it:");
		customer2.setName("Schlog");
		System.out.println(customer2);
		
		System.out.println("\nWow, that is totally the wrong flight, "
				+ "here is the proper one:");
		ticket1.setFlight(flight2);
		System.out.println(ticket1.getFlight().toString());
		
		System.out.println("\nAnd the ticket again:");
		System.out.println(ticket1.toString());
		
		System.out.println("\nIt turns out that Ryan guy actually wants to \n"
				+ "go to Lisbon, so we will give him a new ticket for that \n"
				+ "old flight (at a discount). Here is that new ticket for Ryan:");
		
		// creating something with empty constructor
		AirlineTicket ticket2 = new AirlineTicket();
		ticket2.setPassenger(customer1);
		ticket2.setFlight(flight1);
		ticket2.setPrice(204.69);
		
		System.out.println(ticket2.toString());
		
		System.out.println("\nHere you see Ryan's points updated too:");
		System.out.println(customer1.toString());
		
		System.out.println("\nLets bump Ryan's flight up to be on April 1.");
		ticket2.getFlight().setDeparture("April 1/2017 00:40 PM");
		System.out.println(ticket2.toString());
		
		System.out.println("\nNothing changed because it was an invalid format.\n"
				+ "The Regex caught it. Lets make it proper now:");
		ticket2.getFlight().setDeparture("04/01/2017 05:00 PM");
		System.out.println(ticket2.toString());
		
		System.out.println("\nOut of curiosity, lets see what a default "
				+ "flight looks like:");
		Flight flight3 = new Flight(); // create a default flight
		System.out.println(flight3.toString());
		System.out.println("Noice");
	}
}
