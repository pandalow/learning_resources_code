
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Driver {
	public static void main(String[] args) {
		
		Company company = new Company();
		
		company.addBranch("lonv", 0);
		company.addBranch("didna", 1);
		
		company.getBranches().get(0).addEmployee("Lonely", 0);
		company.getBranches().get(1).addEmployee("Flower", 1);
		
		serializable(company);
		
		Company company1 = deserializable();
		for(int i = 0; i < company1.getBranches().size();i++) {
			System.out.println(company1.getBranches().get(i).toString());
			for(int x = 0; x < company1.getBranches().get(i).getEmployeeList().size();x++) {
				System.out.println(company1.getBranches().get(i).getEmployeeList().get(x).toString());
			}
		}
		
		
		
	}
	
	public static void serializable(Company company) {
		try {
			FileOutputStream fileWrite = new FileOutputStream("file.dat");
			ObjectOutputStream os = new ObjectOutputStream(fileWrite);
			
			os.writeObject(company);
			os.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Company deserializable(){
		Company company = new Company();
		try{
			FileInputStream fileRead = new FileInputStream("file.dat");
			ObjectInputStream os = new ObjectInputStream(fileRead);
			company = (Company) os.readObject();
			os.close();
		}catch(Exception e) {e.printStackTrace();}
		return company;
	} 
	

}
