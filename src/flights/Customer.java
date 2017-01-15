package flights;

/**
 * This class represents a customer at an airport. It has the basic details
 * of the customer that the airport would need including name, address,
 * membership number, and membership points.
 * 
 * Assumptions/Restrictions: None.
 * 
 * Noteworthy Features: Added removePoints method because points need to
 * decrease in some situations, one of which shown in testing. Filled in
 * default data in default constructor to avoid NREs.
 * 
 * @author Ryan Amaral
 *
 */
public class Customer {
	
	private String name;
	private String address;
	private int membershipNumber;
	private int membershipPoints;
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name -> the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address -> the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the membershipNumber
	 */
	public int getMembershipNumber() {
		return membershipNumber;
	}

	/**
	 * @param membershipNumber -> the membershipNumber to set
	 */
	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	/**
	 * @return the membershipPoints
	 */
	public int getMembershipPoints() {
		return membershipPoints;
	}

	/**
	 * @param membershipPoints -> the membershipPoints to set
	 */
	public void setMembershipPoints(int membershipPoints) {
		this.membershipPoints = membershipPoints;
	}

	
	/**
	 * Creates a customer filled with default values.
	 */
	public Customer(){
		setName("Anonymous");
		setAddress("Unknown");
		setMembershipNumber(-1); // -1 means not registered as member
		setMembershipPoints(0);
	}
	
	
	/**
	 * Creates a customer with the specified values and with points set 
	 * to 0.
	 * 
	 * @param name -> The name of the customer.
	 * @param address -> The address of the customer.
	 * @param membershipNumber -> The membership number of the customer.
	 */
	public Customer(String name, String address, int membershipNumber){
		setName(name);
		setAddress(address);
		setMembershipNumber(membershipNumber);
		setMembershipPoints(0);
	}
	
	public String toString(){
		return getName() + ", " + getAddress() + ", #" + 
				getMembershipNumber() + ", " + 
				getMembershipPoints() + " points";
	}
	
	
	/**
	 * Give points to the customer based on the price of the ticket.
	 * 
	 * @param ticket -> the ticket to obtain points from.
	 * @return Returns the new amount of points that the customer has.
	 */
	public int applyPoints(AirlineTicket ticket){
		setMembershipPoints(membershipPoints + 
				(int)Math.round(ticket.getPrice() / (double)100));
		return getMembershipPoints();
	}
	
	/**
	 * Removes points from the customer based on the price of the ticket.
	 * This happens if a customer is accidentally placed on the ticket and
	 * needs to be removed.
	 * 
	 * @param ticket -> the ticket.
	 * @return Returns the new amount of points that the customer has.
	 */
	public int removePoints(AirlineTicket ticket){
		setMembershipPoints(membershipPoints - 
				(int)Math.round(ticket.getPrice() / (double)100));
		return getMembershipPoints();
	}
}
