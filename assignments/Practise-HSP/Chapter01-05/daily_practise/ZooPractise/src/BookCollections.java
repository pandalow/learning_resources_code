import java.util.List;
import java.util.LinkedList;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class BookCollections implements Serializable {

	List<Book> bookCollections = new LinkedList<>();

	public BookCollections() {
	}

	public List<Book> getCollection() {
		return bookCollections;
	}

	public boolean addBooks(Book book) {
		boolean isAddSuccessful = bookCollections.add(book);
		return isAddSuccessful;
	}

	public boolean removeBooks(Book book) {
		boolean isRemoveSuccessful = bookCollections.remove(book);
		return isRemoveSuccessful;
	}

	public void Serialise() {
		try {
			FileOutputStream fileStream = new FileOutputStream("Collections.dat");
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(bookCollections);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void printCollection() {
		Iterator<Book> itr = bookCollections.iterator();
		while(itr.hasNext()){
		System.out.println(itr.next().toString());}
	}
}
