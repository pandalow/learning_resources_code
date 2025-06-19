
public class Bicycle01 {

// Data Members
	private String name;
// Constructor
	public Bicycle01() {
		
	}
	
//	Getter
	public String getName() {
		return name;
	}
//	Setter
	public void setName(String name) {
		this.name = name;
//		or maybe use name = n
	}
//	Override
	public String toString() {
		return getName() + "owns this bicycle";

	}
	



}

