package Wrapper.src.com.collecti;

import java.util.*;

public class ListEx2 {
    public static void main(String[] args) {
        List books = new LinkedList();
        books.add(new Book("ss", 21.5, "kuku"));
        books.add(new Book("fff", 121.3, "f111"));
        books.add(new Book("zng", 2.11, "fngn"));

        ListEx2.bubbleSort(books, (Comparator<Book>) (o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        Iterator iterator = books.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next.toString());
        }

    }

    public static void bubbleSort(List list, Comparator comparator) {
        Book temp;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    temp = (Book) list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}

class Book {
    String name;
    double price;
    String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}