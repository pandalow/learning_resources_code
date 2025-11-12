
public class Book implements Relatable{
	private String title;
	private double price;
	private Publisher publisher;

	
	public Book() {
		this.title =null;
		this.price = 0.0;
		publisher = new Publisher();
	}
	public Book(String title,Publisher publisher, double price) {
		this.title = title;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public String toString() {
		return "title is " + title + "price is " + price + publisher.toString();
	}
	public int greaterThan(Relatable relate) {
		Book book = (Book)relate;
		return Double.compare(this.price, book.price);
	}
}
