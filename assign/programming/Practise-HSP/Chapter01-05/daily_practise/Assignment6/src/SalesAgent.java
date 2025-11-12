
public class SalesAgent extends SalesEmployee {
//Constructor
	public SalesAgent() {
		super();
	}

	public SalesAgent(String firstName, String lastName, String ppsNumber) {
		super(firstName, lastName, ppsNumber);
	}

	public void calculateCommission() {
		commission = sales * 0.1;
	}
}
