
public class Mystery extends Book{
	public Mystery(String title, String isbn) {
		super(title,isbn);
	}
	
	public String toString() {
		return "Type is Mystery" + getTitle() ;
	}
	
	
}
