package _2026_09_14;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FinalOpsPractice0914 {

    record Order(String customer, int amount){}

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("가은", 12000),
                new Order("나은", 30000),
                new Order("다은", 5000),
                new Order("라은", 30000)
        );

        long bigOrders = orders.stream()
                .filter(o -> o.amount() >= 20000) //20000이상인 원소들만 통과
                .count(); //개수세서 최종연산

        Optional<Order> cheapest = orders.stream()
                .min(Comparator.comparingInt(Order::amount)); // 제일 작은거 최종연산인가?

        Optional<Order> mostExpensive = orders.stream()
                .max(Comparator.comparingInt(Order::amount)); //제일큰거

        boolean hasHuge = orders.stream().anyMatch(o -> o.amount() >= 100000); // 10만보다 큰게 하나라도 있는지, 찾으면 바로 종료인가
        boolean allPositive = orders.stream().allMatch(o -> o.amount() >= 0); // 전부다 0 이상인지 검사

        int total = orders.stream()
                .mapToInt(Order::amount) //기억이 안난다
                .sum(); //더하기

        int totalByReduce = orders.stream()
                .map(Order::amount) //기억이 안남
                .reduce(0, Integer::sum); //위에 map에서 통과한 원소들을 0부터 시작해서 다 더하기

        System.out.println(bigOrders);
        System.out.println(cheapest);
        System.out.println(mostExpensive);
        System.out.println(hasHuge);
        System.out.println(allPositive);
        System.out.println(total);
        System.out.println(totalByReduce);
    }
}
