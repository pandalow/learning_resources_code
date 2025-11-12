import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tester implements Serializable {
	public static void main(String[] args) {

		List<Integer> array = new ArrayList<>();

		int q = 1;
		for (int i = 0; i < 10; i++) {
			array.add(q++);
		}

		int sum = 0;

		for (int i = 0; i < array.size(); i++) {
			sum += array.get(i);
		}

		for (Integer a : array) {
			System.out.println(a);
		}
		System.out.println(sum);

	}
	
	public static void writeFile(List<Integer> list) {
		try {
			FileWriter fileWriter = new FileWriter("Array.txt");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write("Integer List \n");
			
			for(Integer a: list) {
				writer.write(a);
			}
				
			writer.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void readFromFile(String filename) {
		try {
			File list = new File("Array.txt");
			FileReader fileRead = new FileReader(list);
			BufferedReader buffer = new BufferedReader(fileRead);
			
			String line = null;
			
			while((line = buffer.readLine()) != null) {
				System.out.println(line);
				
			}
			buffer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
