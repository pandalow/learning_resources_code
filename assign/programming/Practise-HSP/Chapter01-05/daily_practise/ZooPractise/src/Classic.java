
public class Classic extends Book{
	public Classic(String title, String isbn) {
		super(title,isbn);
	}
	
	public String toString() {
		return "Type is Classic" + getTitle() ;
	}
	
	
}
