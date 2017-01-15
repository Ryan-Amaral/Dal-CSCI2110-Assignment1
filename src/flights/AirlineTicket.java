package flights;

/**
 * This class represents a ticket on a flight. I contains a reference to
 * the customer that this ticket belongs to, the flight the ticket is for,
 * and the price of the ticket.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: Applying points to customers (and taking away
 * points if a mistake was made) happens automatically in the set passenger
 * method.
 * 
 * @author Ryan
 *
 */
public class AirlineTicket {

	private Customer passenger;
	private Flight flight;
	private double price;
	
	/**
	 * @return the passenger
	 */
	public Customer getPassenger() {
		return passenger;
	}
	/**
	 * @param passenger -> the passenger to set
	 */
	public void setPassenger(Customer passenger) {
		// remove points from old passenger of this ticket
		if(getPassenger() != null){
			getPassenger().removePoints(this);
		}
		this.passenger = passenger;
		getPassenger().applyPoints(this);
	}
	
	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}
	/**
	 * @param flight -> the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price -> the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Creates an AirlineTicket object with price set to 0. This does not 
	 * give a default customer or flight.
	 */
	public AirlineTicket(){
		setPrice(0);
	}
	
	/**
	 * Creates an AirlineTicket object with the specified values.
	 * 
	 * @param passenger -> The customer that this ticket belongs to.
	 * @param flight -> The flight that this ticket is for.
	 * @param price -> The price of the ticket.
	 */
	public AirlineTicket(Customer passenger, Flight flight, double price){
		setPrice(price); // set price first so passenger gets points
		setPassenger(passenger);
		setFlight(flight);
	}
	
	public String toString(){
		return getPassenger().getName() + 
				", Flight " + getFlight().getFlightNumber() + ", " + 
				getFlight().getOrigin() + " to " + 
				getFlight().getDestination() + ", " + 
				getFlight().getDeparture() + ", $" + getPrice();
	}
}
