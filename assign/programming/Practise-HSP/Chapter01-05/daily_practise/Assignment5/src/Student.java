class Student {
// Declare variables
	private String name;
	private long id;	
	private String grade;	
	private int[] test;
// Declare the instants variables	
	private final int NUM_TESTS = 3;

// Constructor
	public Student() {
		this("Unknown",0000);
	}

	public Student(String name, long id) {
		this.name = name;
		this.id = id;
		this.test = new int[NUM_TESTS];
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setID(long id) {
		this.id = id;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setTestScore(int index, int score) {
		test[index] = score;
	}
	
	// Getter
	// Set an integer as index
	public int getScore(int index) {
		return test[index];
	}
	
	public int getNumTests() {
		return NUM_TESTS;
	}
	
	public String getName() {
		return name;
	}
	
	public long getID() {
		return id;
	}
	
	public String getGrade() {
		return grade;
	}
	
//override toString method to populate content
	public String toString(){
		return "id " + id + ", name " + name + " is " + getGrade() + " Exam ";
	}
	
	public void calculateResult() {
	}
}
