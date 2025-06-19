import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;
class Contact{
	
	private String name;
	private long number;
	
	// Constructor & default variables
	public Contact() {
		this("null",0);
	}
	
	public Contact(String name,long number) {
		this.name = name;
		this.number = number;
	}
//Getter method
	public String getName() {
		return name;
	}
	
	public long getNumber() {
		return number;
	}
//Setter method
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
//Override (to String) method
	public String toString() {
		return "Name is " + name + ", number is " + number;
	}
}



public class Assignment4 {
	public static void main(String[] arg) {
		
		List<Contact> mylist = new ArrayList<>();
//Create an ArrayList and populate it with 4 Contact objects.
		mylist.add(new Contact("NULL",4212));
		mylist.add(new Contact("NULL",3214));
		mylist.add(new Contact("NULL",5982));
		mylist.add(new Contact("NULL",7788));
		
//Use a ListIterator to traverse the list in both directions displaying its contents
		ListIterator<Contact> itr = mylist.listIterator();
		System.out.println("This is the forward order traversal method");
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		System.out.println("This is the reverse order traversal method");
			while(itr.hasPrevious()) {
				System.out.println(itr.previous());
			}
		
//Display the size of the list.(use.size method)
		System.out.println("The list size is " + mylist.size());
		
//Request the user to input the name of a contact in the list.
		Scanner scanner = new Scanner(System.in);
		
		int i = 0;
		System.out.println();
		System.out.println("Enter the name of the element in the list");
		
		do {
			System.out.print("Please enter name: ");	
			String input = scanner.nextLine();
			mylist.get(i).setName(input);			
			i++;
		}
		while(i < mylist.size());
		
		System.out.println("Input program terminated");
		System.out.println();

		
//Use an enhanced for loop to search the list for the contact name given by the user and return the index of location.
		System.out.print("Please Enter Searching Name: ");
		String inputName = scanner.next();
//Set variable to trace index
		int index = 0;
//assign mylist value to variable s 
		for(Contact s : mylist){
			if(s.getName().equals(inputName)) {
//get index method
				index = mylist.indexOf(s);
//for printing out the reality index, variable need to be add 1
				System.out.println("The index is " + (index + 1));
			}
		}
		if(index == 0) {
			System.out.println("Can't find the name.");
		}
//Remove the contact.
		mylist.remove(index);
				
//Use an enhanced for loop to display the contents of the list.		
		System.out.println();
		for(Contact p : mylist) {
			System.out.println(p.toString());
		}		
	}
}



