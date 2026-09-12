package _2026_09_12;

import java.util.function.*;

public class LibraryDrill {

    record Book(String title, int stock){}


    public static void main(String[] args) {

        Book book = new Book("자바의 정석", 3);

        Predicate<Book> passed = book1 -> book1.stock() >= 1;
        Function<Book, String> tit = Book::title;
        Consumer<Book> titst = book1 -> System.out.println(book1.title() + ", 재고 : " + book1.stock()); //얘랑
        Supplier<Book> new1 = () -> new Book("신간", 0); //얘는 될거같은데 어떻게 할지를 모르겠네
        BiFunction<Integer, Integer, Integer> dae = (a, b) -> a - b;

        System.out.println(passed.test(book));
        System.out.println(tit.apply(book));
        titst.accept(book);
        System.out.println(new1.get().title());
        System.out.println(dae.apply(5,2));

        ToIntFunction<String> intgo = Integer::parseInt; //1번
        String intgo1 = "12";
        System.out.println(intgo.applyAsInt(intgo1));

        Consumer<Book> titst1 = System.out::println; //2번
        titst1.accept(book);

        Function<String, String> gongno = String::strip; //3번
        System.out.println("|" + gongno.apply("  자바의 정석  ") + "|");

        BiFunction<String, Integer, Book> newBook = Book::new; //4번
        System.out.println(newBook.apply("신간", 0).title());

    }
}
