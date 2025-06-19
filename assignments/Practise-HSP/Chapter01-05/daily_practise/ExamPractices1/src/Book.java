public class Book implements Relatable,Comparable<Book>{
	private String title;
	private double price;
	private Publisher publisher;
	
	public Book() {}
	
	public Book(String title,Publisher publisher,double price) {
		this.title = title;
		this.price = price;
		this.publisher = publisher ;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return 1;
	}
	
	public Publisher getPubliser() {
		return publisher;
	}
	
	public int greaterThan(Relatable relate) {
		Book books = (Book)relate;
		return books.compareTo(books);
	}
}
