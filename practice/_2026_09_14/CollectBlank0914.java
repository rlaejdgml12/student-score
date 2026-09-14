package _2026_09_14;


import java.util.*;
import java.util.stream.Collectors;

public class CollectBlank0914 {

    record Movie(String title, String genre, int score) {}

    public static void main(String[] args) {

        List<Movie> movies = List.of(
            new Movie("전투의 서막", "액션", 85),
            new Movie("불꽃 추격전", "액션", 78),
            new Movie("웃음 대작전", "코미디", 65),
            new Movie("눈물의 밤", "드라마", 92),
            new Movie("고요한 이별", "드라마", 88)
        );

        // 여기부터 직접 작성하세요.

        Map<String, Long> count = movies.stream()
                .collect(Collectors.groupingBy(Movie::genre, Collectors.counting()));
        System.out.println(count);

        Map<String, Double> avg = movies.stream()
                .collect(Collectors.groupingBy(Movie::genre, Collectors.averagingInt(Movie::score)));
        System.out.println(avg);

        Map<String, String> attach = movies.stream()
                .collect(Collectors.groupingBy(Movie::genre, Collectors.mapping(Movie::title, Collectors.joining(","))));
        System.out.println(attach);

        Set<String> tree = movies.stream()
                .map(Movie::title)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(tree);
    }
}
