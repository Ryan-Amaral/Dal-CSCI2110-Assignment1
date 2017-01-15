package flights;


/**
 * 
 * 
 * @author Ryan
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
	
	public Flight(){
		
	}
	
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
