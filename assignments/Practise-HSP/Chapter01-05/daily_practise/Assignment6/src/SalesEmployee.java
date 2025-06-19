import java.text.DecimalFormat;

public abstract class SalesEmployee {

	// Declare variables
	private String firstName;
	private String lastName;
	private static int bikeEmployeeNumber = 1;
	private String ppsNumber;
	protected double sales = 0.00;
	protected double commission = 0.00;
	private int employeeNumber = 0;

	// Constructor
	public SalesEmployee() {
		this.firstName = "";
		this.lastName = "";
		this.ppsNumber = "";
		this.employeeNumber = bikeEmployeeNumber++;

	}

	public SalesEmployee(String firstName, String lastName, String ppsNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ppsNumber = ppsNumber;
		this.employeeNumber = bikeEmployeeNumber++;
	}

	// Set the firstName, lastName, PPS
	public void setFirstName(String name) {
		this.firstName = name;
	}

	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public void setPPS(String PPS) {
		this.ppsNumber = PPS;
	}

	// Get the value of variables
	public String getfirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPPS() {
		return ppsNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	// Override toString method from Objective method;
	public String toString() {
		// Using DecimalFormat to format the numbers
		DecimalFormat df = new DecimalFormat("0.00");
		return "Employee name is: " + firstName + " " + lastName + "; PPS number is: " + ppsNumber
				+ ";\nEmployee number is: " + employeeNumber + "; Commission is: " + df.format(commission)
				+ "; Total sales is:" + sales + "; Type is " + getClass().getSimpleName();
	};

	// Crate a abstract method called calculateCommission;
	public abstract void calculateCommission();
}
