package AssignmentSelf;
// Cat class that extends Animal
public class Cat extends Animal {
    // Constructor for Cat that calls the superclass constructor
    public Cat(String name, String breed, int size) {
        super(name, breed, size);
    }
    
    // Method to return the sound a cat makes
    public String sound() {
        return "meow";
    }
}