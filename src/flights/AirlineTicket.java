package flights;

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
	
	public AirlineTicket(){
		
	}
	
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
