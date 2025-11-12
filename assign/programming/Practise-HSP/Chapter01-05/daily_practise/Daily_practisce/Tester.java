public class Tester {

    public static void main(String[] args) {

        // Initializing an array of Student objects
        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();

        // Setting names and IDs for each student
        students[0].setName("John");
        students[0].setID(1);
        students[1].setName("Cindy");
        students[1].setID(2);
        students[2].setName("Nicola");
        students[2].setID(3);

        // Displaying each student's information
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }
}

class Student {

    private String name;
    private long idNumber;

    // Default constructor
    public Student() {
        name = "Unassigned";
        idNumber = 0;
    }

    // Getter
    public String getName() {
        return name;
    }
    public long getID() {
        return idNumber;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setID(long idNumber) {
        this.idNumber = idNumber;
    }

    // Overriding the toString() method for a custom string representation
    public String toString() {
        return "Name = " + name + ", ID = " + idNumber;
    }
}