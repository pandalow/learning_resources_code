package AssignmentSelf;
//Dog class that extends Animal
public class Dog extends Animal {
	// Constructor for Dog
	public Dog(String name, String breed, int size) {
		super(name,breed,size);
	}
	 // Method to return the sound a dog makes
	public String sound() {
		return "woo";
	}
}
