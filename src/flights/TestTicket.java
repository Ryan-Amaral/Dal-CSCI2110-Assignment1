package flights;

public class TestTicket {

	public static void main(String[] args){
		Customer customer1 = new Customer("Ryan", "123 Fake Street", 328653);
		Customer customer2 = new Customer("Bob", "321 Real Street", 23435);
		Flight flight1 = new Flight(128, "Halifax", "Lisbon", "02/02/2017 8:00 AM");
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
		
		System.out.println("\nThis advanced system automatically dealt with the points "
				+ "appropriately when the passenger on the ticket changed\n\n"
				+ "I just realized that the passengers name is Schlog, not Bob, "
				+ "now to change it:");
		customer2.setName("Schlog");
		System.out.println(customer2);
	}
}
