package _2026_09_14;

import java.util.Comparator;
import java.util.List;

public class Sorting0914 {
    record Item(String label, int qty){}

    public static void main(String[] args) {
        List<Item> items = List.of( //그냥 뭐 리스트만들기
                new Item("A", 30),
                new Item("B", 10),
                new Item("C", 30),
                new Item("D", 20),
                new Item("A", 30) //0번이랑 똑같은 중복만들기
        );

        List<Item> unique = items.stream()
                .distinct() //중복제거
                .toList(); //최종연산

        List<Item> sorted = unique.stream()
                .sorted(Comparator.comparingInt(Item::qty).reversed() //내림차순
                .thenComparing(Item::label)) //qty 똑같ㅊ으면 라벨로 오름차순
                .toList(); //최종연산

        List<Item> topTwo = sorted.stream()
                .limit(2) // 2개만 출력
                .toList(); //최종연산

        System.out.println(unique);
        System.out.println(sorted);
        System.out.println(topTwo);
    }
}
