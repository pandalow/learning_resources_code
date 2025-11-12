package Exercise;
public class Test{
    public static void main(String[] args) {
        Book bk1 = new Book(20);
                bk1.updatePrice(120);
        System.out.println(bk1.toString());
    }
}
class Book {
    private int price;

    public Book(int price) {
        this.price = price;
    }

    public void updatePrice(int price) {
        if (price > 150) this.price = 150;
        if (price > 100 && price <=150) this.price = 100;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                '}';
    }
}
