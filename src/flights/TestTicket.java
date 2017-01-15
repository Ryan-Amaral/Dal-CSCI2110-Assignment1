package flights;

public class TestTicket {

	public static void main(String[] args){
		Customer customer1 = new Customer("Ryan", "123 Fake Street", 328653);
		Customer customer2 = new Customer("Bob", "321 Real Street", 23435);
		
		Flight flight1 = new Flight(128, "Halifax", "Lisbon", "02/02/2017 08:00 AM");
		Flight flight2 = new Flight(643, "Dartmouth", "Cape Town", "01/20/2017 03:00 AM");
		
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
		AirlineTicket ticket2 = new AirlineTicket(customer1, flight1, 202.96);
		System.out.println(ticket2.toString());
		
		System.out.println("\nHere you see Ryan's point updated too:");
		System.out.println(customer1.toString());
		
	}
}
