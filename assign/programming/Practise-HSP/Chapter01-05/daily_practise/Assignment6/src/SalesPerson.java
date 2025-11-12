public class SalesPerson extends SalesEmployee {
//Constructor
	public SalesPerson() {
		super();
	}

	public SalesPerson(String firstName, String lastName, String ppsNumber) {
		super(firstName, lastName, ppsNumber);
	}

	public void calculateCommission() {

		commission = sales * 0.15;
	}
}
