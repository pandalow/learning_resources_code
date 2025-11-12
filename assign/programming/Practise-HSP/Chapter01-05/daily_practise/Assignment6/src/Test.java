import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		// Create an ArrayList to store SalesEmployee objects.
		List<SalesEmployee> mylist = new ArrayList<>();

		// Initialize a SalesAgent object and set its attributes using setter methods.
		SalesAgent p1 = new SalesAgent();
		String fname1 = "Lily";
		p1.setFirstName(fname1);
		String lname1 = "Ann";
		p1.setLastName(lname1);
		String pps1 = "9238456B";
		p1.setPPS(pps1);

		// Add the SalesAgent object to the list.
		mylist.add(p1);

		// Initialize a SalesPerson object and set its attributes using setter methods.
		SalesPerson p2 = new SalesPerson();
		String fname2 = "Joe";
		p2.setFirstName(fname2);
		String lname2 = "John";
		p2.setLastName(lname2);
		String pps2 = "1234415A";
		p2.setPPS(pps2);

		// Add the SalesPerson object to the list.
		mylist.add(p2);

		// Initialize a SalesAgent object using a constructor with default values.
		SalesAgent p3 = new SalesAgent("Josh", "Love", "7461512C");

		// Add the SalesAgent object to the list.
		mylist.add(p3);

		// Loop through the list and prompt the user to enter sales for each
		// SalesEmployee.
		for (int i = 0; i < mylist.size(); i++) {
			System.out.print("Please enter sales for employee No. " + (i + 1) + ": ");
			Scanner myScan = new Scanner(System.in);
			double nums = myScan.nextDouble();
			mylist.get(i).sales = nums;

			// Calculate commission for the SalesEmployee.
			mylist.get(i).calculateCommission();
		}

		// Use an enhanced for loop to print the details of each SalesEmployee.
		for (SalesEmployee p : mylist) {
			System.out.println(p.toString());
		}
	}
}