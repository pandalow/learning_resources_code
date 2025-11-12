package Wrapper.src.com.Math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ArrayExercise01 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅",90);
        books[2] = new Book("青年文摘",5);
        books[3] = new Book("java从入门到放弃",300);

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                int price1 = o1.getPrice();
                int price2 = o2.getPrice();
                return price1 - price2;
            }
        });
        Arrays.stream(books).forEach(System.out::println);
    }

}

class Book{
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}