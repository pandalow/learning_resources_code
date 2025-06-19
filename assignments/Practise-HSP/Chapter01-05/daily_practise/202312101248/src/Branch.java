import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Branch implements Serializable {
	private String address;
	private int branchNum;
	private List<Employee> branchEmployees;
	
	public Branch(String address, int branchNum) {
		this.address = address;
		this.branchNum = branchNum;
		branchEmployees = new ArrayList<>();
	}
	
	public String getAddress() {
		return address; 
	}
	
	public long getBranchNum() {
		return branchNum;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;

	}
	public void addEmployees(String name,long id) {
		Employee employees = new Employee(name,id);
		branchEmployees.add(employees);
	}
	public List<Employee> getEmployeeList(){
		return branchEmployees;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("Branch Number: ").append(branchNum).append(", Address: ").append(address).append(", Employees: ");
	    for (Employee employee : branchEmployees) {
	        sb.append("\n\t").append(employee.toString());
	    }
	    return sb.toString();
	}

	class Employee implements Serializable{
		private String name;
		private long id;
		
		public Employee(String name, long id) {
			this.name = name;
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public long getID() {
			return id;
		}
		public String toString() {
			return "name is " + name + "id is" + id;
		}
	}
}
