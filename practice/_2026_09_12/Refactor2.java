package _2026_09_12;

import java.util.function.*;

public class Refactor2 {

    record Member(String name, String email) {}

    public static void main(String[] args) {

        Member member = new Member("김동희", "dev@example.com");

        Consumer<Member> mem1 = new Consumer<Member>() {
            @Override
            public void accept(Member member) {
                System.out.println(member.toString());
            }
        };

        Consumer<Member> mem2 = s -> System.out.println(s.toString());

        Consumer<Member> mem3 = System.out::println;

        mem1.accept(member);
        mem2.accept(member);
        mem3.accept(member);
    }
}
