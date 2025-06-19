import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable{
	protected List<Employee> employees;
	
	public Company(){
		employees = new ArrayList<>();
	}
	
	public void addEmployees(String name, long id) {
		Employee employee = new Employee(name,id);
		employees.add(employee);
	}
	
	public void removeEmployees(int index) {
		employees.remove(index);
	}
	public List<Employee> getEmployee(){
		return employees;
	}
	
	class Employee implements Comparable<Employee>,Serializable{
		private String name;
		private long id;
		
		public Employee(String name, long id) {
			this.name = name;
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public long getId() {
			return id;
		}
		public String toString() {
			return "name is " + name + " id is " + id;
		}
		public int compareTo(Employee i) {
			return this.getName().compareTo(i.getName());
					}
		}
}