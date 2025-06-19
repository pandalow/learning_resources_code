package AssignmentSelf;
import java.io.Serializable;
//Define an abstract Animal class that implements Serializable and Comparable interfaces
public abstract class Animal implements Serializable, Comparable<Animal>{
	// Properties of the animal
	private String name;
	private String breed;
	private int size;
	
	//Constructor
	public Animal() {
		this.name = "null";
		this.breed = "null";
		this.size = 0;
	}
	public Animal(String name, String breed, int size) {
		this.name = name;
		this.breed = breed;
		this.size = size;
	}
	// Implement the compareTo method from the Comparable interface for sorting by name
	public int compareTo(Animal animal) {
		return name.compareTo(animal.getName());
	}
	// Getter and Setter methods
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getBreed() {
		return breed;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	// Return a string representation of the animal information
	public String toString() {
		return getClass().getSimpleName() + " Name is " + name + ", breed is " + breed + ", size is " + size;
	};
}
