import java.util.List;
import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		List<Book> book = new ArrayList<>();

		book.add(new Book("life", new Publisher("John", "94 duirling"), 21.5));
		book.add(new Book("Cici", new Publisher("Dive", "New castle"), 52.1));
		book.add(new Book("Doggy", new Publisher("Dragon", "Beijing Shanshui"), 122.5));
		
		System.out.println(findMostExpensive(book).toString());
		
	}

	public static Book findMostExpensive(List<Book> b) {
		Book mostExpences = b.get(0);
		for(int i = 0; i < b.size(); i++) {
			if(mostExpences.greaterThan(b.get(i)) < 0) {
				mostExpences = b.get(i);
			}
		}return mostExpences;
	}
}
