package _2026_08_06;

class Book {
    String title;
    String author;

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }
}

public class Main{
    public static void main(String[] args) {
        Book book = new Book("자바의 정석", "남궁성");
        System.out.println(book.title + " - " + book.author);
    }
}
