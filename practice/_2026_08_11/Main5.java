package _2026_08_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Book{
    private String title;

    public Book(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

}

class BookRepository{
    private final List<Book> bookList;

    public BookRepository(List<Book> bookList){
        this.bookList = bookList;
    }

    public void add(Book book){
        this.bookList.add(book);
    }

    public List<Book> findAll(){
        return bookList;
    }

}

public class Main5 {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        BookRepository repo1 = new BookRepository(bookList);
        repo1.add(new Book("자바의 정석"));
        System.out.println(repo1.findAll());

        List<Book> bookList2 = new LinkedList<>();
        BookRepository repo2 = new BookRepository(bookList2);
        repo2.add(new Book("자바의 정석"));
        System.out.println(repo2.findAll());
    }
}
