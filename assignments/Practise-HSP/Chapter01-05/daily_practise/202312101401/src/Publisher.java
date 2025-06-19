
public class Publisher {
	private String name;
	private String address;
	
	public Publisher() {
		this.name = null;
		this.address = null;
	}
	public Publisher(String name,String address) {
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String toString() {
		return "name is " + name + ",address is " + address;
	}
}
