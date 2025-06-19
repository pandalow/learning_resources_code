package lvo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class FileSerializationDeserialization implements SerializationHandler<Person>,Serializable{
	public FileSerializationDeserialization() {}
	
	public void serialise(List<Person> list) {
		try {
			FileOutputStream fileWrite = new FileOutputStream("Person.dat");
			ObjectOutputStream  os = new ObjectOutputStream(fileWrite);
			os.writeObject(list);
			os.close();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public List<Person> deserialization(){
		
		List<Person> list = new ArrayList<>();
		try {
			FileInputStream fileRead = new FileInputStream("Person.dat");
			ObjectInputStream or = new ObjectInputStream(fileRead);
			list = (List<Person>)or.readObject();
			or.close();
		}catch(Exception e) {e.printStackTrace();}
		return list;
	}
}