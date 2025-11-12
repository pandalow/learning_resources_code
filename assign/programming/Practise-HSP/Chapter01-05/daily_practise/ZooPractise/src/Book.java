import java.io.Serializable;

public abstract class Book implements Serializable {
	private String title;
	
	public Book() {
		this.title = null;
	}
	public Book(String title,String ISBN) {
		this.title = title;
		ISBN isbn = new ISBN();
		isbn.setISBN(ISBN);
	}
	
	public String getTitle() {
		return title;
	}	
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		return title  + getClass().getSimpleName();
	}
	
}	
