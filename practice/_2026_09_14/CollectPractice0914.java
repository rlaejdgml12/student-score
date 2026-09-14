package _2026_09_14;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectPractice0914 {

    record Book(String title, String genre, int price){}

    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book("자바의 정석", "IT", 30000),
                new Book("이펙티브 자바", "IT", 35000),
                new Book("코스모스", "과학", 20000),
                new Book("사피엔스", "인문", 25000),
                new Book("총균쇠", "인문", 27000)
        );

        Map<String, Integer> priceByTitle = books.stream()
                .collect(Collectors.toMap(Book::title, Book::price)); // 정확히는 모르겠지만 각 객체를 타이틀-가격으로 묶어서 맵에 저장 이거같음
        System.out.println(priceByTitle);

        Map<String, Long> countByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre, Collectors.counting())); // genre별로 그룹지어서 개수세기
        System.out.println(countByGenre);

        Map<String, Double> avgPriceGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre, Collectors.averagingInt(Book::price))); // genre별로 그룹지어서 평균 이건가 근데 왜 int지 Double이 아니라
        System.out.println(avgPriceGenre);

        Map<String, String> titlesByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre, Collectors.mapping(Book::title, Collectors.joining(", ")))); // genre별로 그룹지어서, 이걸 이제 하나의 문자열로 , 사이에 이거 넣어서
        System.out.println(titlesByGenre);

    }
}
