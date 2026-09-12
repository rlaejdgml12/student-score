package _2026_09_12;

import java.util.function.*;

public class StandardFunctionalDemo {

    record Student(String name, int score) {}

    public static void main(String[] args) {
        Student s = new Student("김동희", 75);

        Predicate<Student> passed = stu -> stu.score() >= 60; // 매개변수(stu) 받아서 boolean(60보다 같거나 크면) 반환
        Function<Student, String> toName = stu -> stu.name(); // 매개변수(stu) 하나 받아서 STring으로 반환(stu.name)
        Consumer<Student> print = stu -> System.out.println(stu.name() + " / " + stu.score()); // 매개변수(stu) 하나 받아서 반환은 안함 여기선 출력만
        Supplier<Student> factory = () -> new Student("신입생", 0); // 아무것도 안받고 새 스튜던트 객체만 돌려줌
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b; // 매개변수 두개(a, b) 받아서 더한값인 인테저로 반환함

        System.out.println(passed.test(s));
        System.out.println(toName.apply(s));
        print.accept(s);
        System.out.println(factory.get().name());
        System.out.println(sum.apply(70, 30));

    }
}
