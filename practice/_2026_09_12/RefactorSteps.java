package _2026_09_12;

import java.util.function.*;

public class RefactorSteps {

    record Book(String title, int stock) {}

    public static void main(String[] args) {

        Book book = new Book("이펙티브 자바", 5);

        Function<String, Integer> len1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Function<String, Integer> len2 = s -> s.length();

        Function<String, Integer> len3 = String::length;

        System.out.println(len1.apply(book.title()));
        System.out.println(len2.apply(book.title()));
        System.out.println(len3.apply(book.title()));

    }
}
