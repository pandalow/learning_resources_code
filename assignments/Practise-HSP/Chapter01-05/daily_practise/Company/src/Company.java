import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
public class Company implements Serializable{
	
	protected List<Branch> branches = new ArrayList<>();
	
	public Company() {}
	
	public void addBranch(String address,int branchNum) {
		Branch branch = new Branch(address,branchNum);
		branches.add(branch);
	}
	
	public void removeBranch(int index) {
		branches.remove(index);
	}
	
	public List<Branch> getBranches(){
		return branches;
	}
	
	public class Branch implements Serializable{
		private String address;
		private int branchNum;
		List<Employee> branchEmployee = new ArrayList<>();
		
		public Branch(String address, int branchNum) {
			this.address = address;
			this.branchNum = branchNum;
		}
		public String getAddress() {
			return address;
		}
		public long getBranchNum() {
			return (long)branchNum;
		}
		
		public void addEmployee(String name, long id) {
			Employee employee = new Employee(name,id);
			branchEmployee.add(employee);
		}
		public List<Employee> getEmployeeList(){
			return branchEmployee;
		}
		public String toString() {
			return "Address is " + address + "Branch Number are" + branchNum; 
				}
	}
	
	public class Employee implements Serializable{
		private String name;
		private long id;
		public Employee(String name, long id) {
			this.name = name;
			this.id = id;
		}
		
		public String getName() {return name;}
		public long getID() {return id;}
		public String toString() {return "Name is" + name + "id is " + id;}
	}
}
