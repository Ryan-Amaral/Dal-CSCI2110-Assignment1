package flights;

public class Customer {
	
	private String name;
	private String address;
	private int membershipNumber;
	private int membershipPoints;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getMembershipNumber() {
		return membershipNumber;
	}
	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}
	
	public int getMembershipPoints() {
		return membershipPoints;
	}
	public void setMembershipPoints(int membershipPoints) {
		this.membershipPoints = membershipPoints;
	}
	
	public Customer(){
		
	}
	
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
	
	public int applyPoints(AirlineTicket ticket){
		setMembershipPoints(membershipPoints + 
				(int)Math.round(ticket.getPrice() / (double)100));
		return getMembershipPoints();
	}
	
	public int removePoints(AirlineTicket ticket){
		setMembershipPoints(membershipPoints - 
				(int)Math.round(ticket.getPrice() / (double)100));
		return getMembershipPoints();
	}
}
