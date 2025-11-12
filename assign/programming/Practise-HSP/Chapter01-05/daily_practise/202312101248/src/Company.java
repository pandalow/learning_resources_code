import java.util.List;
import java.util.ArrayList;
public class Company{
	protected List<Branch> branches;
	
	public Company() {
		branches = new ArrayList<>();
	}
	
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
}
