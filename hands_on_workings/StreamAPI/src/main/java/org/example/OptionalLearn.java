package org.example;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OptionalLearn {
    public static void main(String[] args) {
        List<Author> authors = SteramTest.getAuthors();
        Optional<Author> author = Optional.ofNullable(authors.get(0));
//        Optional<Author> authors1 = Optional.ofNullable(authors.get(1));
//
//        authors1.ifPresent(author -> System.out.println(author.getName()));

//        Optional<Author> author = getAuthor();
//        author.ifPresent(i -> System.out.println(i.getAge()));

//        Optional<Author> author = getAuthor();
//        author.ifPresent(i-> System.out.println(i.getName()));

//        Optional<Author> author = getAuthor();
//        author.get();
//        if (author.isPresent()) {
//            Author author1 = author.orElseThrow(() -> new RuntimeException());
//        }

        author.map(author1 -> author1.getBooks()).ifPresent(books-> System.out.println(books.get(1)));

    }
    private static Optional<Author> getAuthor(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return Optional.ofNullable(author);
//        return null;
    }
}
