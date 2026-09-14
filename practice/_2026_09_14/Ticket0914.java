package _2026_09_14;

import java.util.Comparator;
import java.util.List;

public class Ticket0914 {

    record Ticket(String holder, int price){}

    public static void main(String[] args) {

        List<Ticket> tickets = List.of(
                new Ticket("민수", 50000),
                new Ticket("영희", 30000),
                new Ticket("철수", 70000),
                new Ticket("지훈", 30000),
                new Ticket("민수", 50000)   // ← 위 첫 번째 티켓과 완전히 같은 중복
        );

        List<Ticket> unique = tickets.stream()
                .distinct()
                .toList();

        List<Ticket> sorted = unique.stream()
                .sorted(Comparator.comparingInt(Ticket::price)
                        .thenComparing(Comparator.comparing(Ticket::holder).reversed()))
                .toList();


        List<Ticket> go = sorted.stream()
                .skip(1)
                .limit(2)
                .toList();

        System.out.println(unique);
        System.out.println(sorted);
        System.out.println(go);

    }
}
