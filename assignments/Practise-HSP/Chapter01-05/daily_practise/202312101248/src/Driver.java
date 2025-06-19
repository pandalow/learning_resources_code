import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ListIterator;

public class Driver {
	public static void main(String[] args) {
		Company company = new Company();
		
		company.addBranch("94 duirling,Galway", 94);
		company.addBranch("New castle,Galway", 211);
		
		company.getBranches().get(0).addEmployees("Doggy", 12);
		company.getBranches().get(0).addEmployees("Dive", 50);
		
		company.getBranches().get(1).addEmployees("Cool", 11);
		company.getBranches().get(1).addEmployees("Lier", 80);
		
		ListIterator<Branch> branches = company.getBranches().listIterator();
		
		while(branches.hasNext()) {
			Branch branchee = branches.next();
			System.out.println(branchee.toString());
		}
		
		System.out.println("");
		serilised(company.getBranches());
		deserialised();
	}
	
	public static void serilised(List<Branch> list) {
		try {
			FileOutputStream fileWriter = new FileOutputStream("File.dat");
			ObjectOutputStream os = new ObjectOutputStream(fileWriter);
			
			os.writeObject(list);
			os.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void deserialised() {
		try {
			FileInputStream fileReader = new FileInputStream("file.dat");
			ObjectInputStream os = new ObjectInputStream(fileReader);
			List<Branch> list = (List<Branch>)os.readObject();
			for(Branch ee : list) {
				System.out.println(ee.toString());
			}
			os.close();
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
