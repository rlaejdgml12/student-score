package _2026_09_14;

import java.util.*;

public class FinalOpsBlank0914 {

    record Employee(String name, int salary){}

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("가은", 4200),
                new Employee("나은", 5800),
                new Employee("다은", 3100),
                new Employee("라은", 6500),
                new Employee("마은", 5000)
        );

        long count1 = employees.stream()
                .filter(e -> e.salary() >= 5000)
                .count();

        Optional<Employee> max1 = employees.stream()
                .max(Comparator.comparingInt(Employee::salary));

        Optional<Employee> min1 = employees.stream()
                .min(Comparator.comparingInt(Employee::salary));

        boolean mm = employees.stream().anyMatch(e -> e.salary() >= 100_000_000);

        int sum = employees.stream()
                .mapToInt(e -> e.salary())
                .sum();

        OptionalDouble avg = employees.stream()
                .mapToDouble(e -> e.salary())
                .average();

        IntSummaryStatistics all = employees.stream()
                .mapToInt(e -> e.salary())
                .summaryStatistics();

        System.out.println(count1);
        System.out.println(max1);
        System.out.println(min1);
        System.out.println(mm);
        System.out.println(sum);
        System.out.println(avg);
        System.out.println(all.getSum() + ", " + all.getAverage() + ", " + all.getMin() + ", " + all.getMax() + ", " + all.getCount());


    }
}
