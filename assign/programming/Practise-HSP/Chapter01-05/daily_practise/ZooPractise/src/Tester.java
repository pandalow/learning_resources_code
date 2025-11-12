
public class Tester {
	public static void main(String[] args) {
		
		BookCollections collections = new BookCollections();
		
		Mystery myth1 = new Mystery("Love","ISBN122124");
		collections.addBooks(myth1);
		Mystery myth2 = new Mystery("Gun","ISSNF224124");
		collections.addBooks(myth2);
		Classic old1 = new Classic("Gone with wind","ISBN2121245");
		collections.addBooks(old1);
		
		collections.printCollection();
		
		collections.Serialise();
		
	}
}
