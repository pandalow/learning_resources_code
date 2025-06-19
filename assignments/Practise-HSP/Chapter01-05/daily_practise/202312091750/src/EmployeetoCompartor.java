import java.util.Comparator;
public class EmployeetoCompartor implements Comparator<Company.Employee>{
	public int compare(Company.Employee a, Company.Employee b) {
		return Long.compare(a.getId(), b.getId());
	}
}