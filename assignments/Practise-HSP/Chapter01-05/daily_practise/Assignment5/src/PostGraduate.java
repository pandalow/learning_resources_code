class PostGraduate extends Student{
	
	//Constructor
	public PostGraduate(){
		
	}
	//Constructor inherited from main class
	public PostGraduate(String name,long id){
		super(name,id);
	}
	//Override the main calculate class method
	public void calculateResult() {
		int sumScore = 0;
		int NUMS = getNumTests();
	
		for(int i = 0;i < NUMS;i++) {			
			sumScore += getScore(i);
		}
		
		if((sumScore / 3) >= 50) {
			setGrade("PASS");
		}else {
			setGrade("FAIL");
		}		
	}
}