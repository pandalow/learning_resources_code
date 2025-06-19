package AssignmentSelf;

import java.util.List;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Define the main test class
public class Tester {

 // Entry point of the program
 public static void main(String[] args) {
     
     // Create instances of Cat and Dog objects
     Cat cat1 = new Cat("Lily", "yellow", 12);
     Cat cat2 = new Cat("Jet", "black", 10);
     Dog dog1 = new Dog("Cow", "black", 14);
     Dog dog2 = new Dog("Rough", "white", 8);

     // Initialize a LinkedList to hold Animal objects
     List<Animal> mylist = new LinkedList<>();
     mylist.add(cat1);
     mylist.add(cat2);
     mylist.add(dog1);
     mylist.add(dog2);

     // Print out all animal information
     for (Animal animal : mylist) {
         System.out.println(animal.toString());
     }
     
     // Sort the list by name using Animal class's compareTo method
     Collections.sort(mylist);
     System.out.println("");

     // Print out the sorted animal information again
     for (Animal animal : mylist) {
         System.out.println(animal.toString());
     }
     
     // Define an inner class for sorting animals by breed
     class Inner implements Comparator<Animal> {
         public int compare(Animal a1, Animal a2) {
             return a1.getBreed().compareTo(a2.getBreed());
         }
     }
     Inner inn = new Inner(); // Instantiate the inner class
     Collections.sort(mylist, inn); // Use the inner class to sort the list

     System.out.println("");
     // Use an iterator to print the sorted list
     Iterator<Animal> itr = mylist.iterator();
     while (itr.hasNext()) {
         Animal animal = itr.next();
         System.out.println(animal.toString());
     }
     
     // Define another inner class for sorting by size
     class Inner2 implements Comparator<Animal>{
         public int compare(Animal a1, Animal a2) {
             return Integer.compare(a1.getSize(), a2.getSize());
         }
     }
     Inner2 inn2 = new Inner2(); // Instantiate the second inner class
     Collections.sort(mylist, inn2); // Use the second inner class to sort the list
     
     // Reset the iterator and print the final sorted list
     itr = mylist.iterator();
     System.out.println("");
     while(itr.hasNext()) {
         Animal animal = itr.next();
         System.out.println(animal.toString());
     }
     
     // Serialize the list to a file
     try {
         FileOutputStream fileStream = new FileOutputStream("Animal.dat");
         ObjectOutputStream os = new ObjectOutputStream(fileStream);
         os.writeObject(mylist);
         os.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
     
     // Deserialize the list from the file and print it
     try {
         FileInputStream fileStream = new FileInputStream("Animal.dat");
         ObjectInputStream os = new ObjectInputStream(fileStream);
         List<Animal> list = (List<Animal>)os.readObject();
         System.out.println("");
         Iterator<Animal> iter = list.iterator() ;
         while(iter.hasNext()) {
             Animal animal = iter.next();
             System.out.println(animal.toString());
         }
         
     }catch(Exception e) {
         e.printStackTrace();
     }
 }
}
