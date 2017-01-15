package flights;


/**
 * This class represents a flight at an airport. It has the basic details
 * of the flight including the number, origin, destination, and departure 
 * time/date.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: Filled in default data in default constructor to 
 * avoid NREs.
 * 
 * @author Ryan Amaral
 *
 */
public class Flight {

	private int flightNumber;
	private String origin;
	private String destination;
	private String departure;
	
	/**
	 * @return the flight number
	 */
	public int getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param flightNumber -> the flight number to set
	 */
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin -> the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination -> the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * @param departure -> the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	/**
	 * Creates a flight object filled with default values.
	 */
	public Flight(){
		setFlightNumber(-1); // -1 if no number (secret mission or something)
		setOrigin("Unknown");
		setDestination("Unknown");
		setDeparture("00/00/0000 00:00 AM");
	}
	
	/**
	 * Creates a flight object with the specified values.
	 * 
	 * @param flightNumber -> The number/id of the flight.
	 * @param origin -> Where the flight is leaving from.
	 * @param destination -> Where the flight is going to.
	 * @param departure -> When the flight is leaving.
	 */
	public Flight(int flightNumber, String origin, String destination, String departure){
		setFlightNumber(flightNumber);
		setOrigin(origin);
		setDestination(destination);
		setDeparture(departure);
	}
	
	public String toString(){
		return "Flight " + getFlightNumber() + ", " +
				getOrigin() + " to " + getDestination() + ", " +
				getDeparture();
	}
}
