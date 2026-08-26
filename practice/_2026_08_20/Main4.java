package _2026_08_20;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("banana", 3);
        map.put("apple", 5);
        map.put("apple", 99); // 순서나 이런건 안변하는데 밸류는 덮어씌워짐 그래서 바나나,3 / 애플, 99 이렇게 남음
        System.out.println("① " + map);

        Map<String, Integer> count = new HashMap<>();
        for(String word : "java spring java jpa spring java".split(" ")){ // 저 문장을 스페이스바 기준으로 나눠서 word에 하나씩 담아서 for문 돌리기
            count.merge(word, 1, Integer::sum); //맵에 이제 각 단어를 담아서 이제 없으면 키를 새로 만들고 있으면 count +1 이런식으로
        }
        System.out.println("② java=" + count.get("java")); //출력
        System.out.println("② spring=" + count.get("spring")); //출력

        Map<String, List<String>> group = new HashMap<>();
        group.computeIfAbsent("backend", k -> new ArrayList<>()).add("spring"); //백엔드가 없으면 백엔드라는 새 리스트를 만들어서 스프링 추가
        group.computeIfAbsent("backend", k -> new ArrayList<>()).add("jpa"); //위랑 동일한데 추가하는거만 jpa
        group.computeIfAbsent("frontend", k -> new ArrayList<>()).add("react"); //이건 프론트엔드가 없으면 새 리스트 만들어서 리엑트 추가
        System.out.println("③ " + group);

        Deque<String> stack = new ArrayDeque<>(); // 디큐로 스택만들기
        stack.push("A"); // a넣기
        stack.push("B"); // b넣기
        System.out.println("④ stack pop = " + stack.pop()); //그냥 팞해서 출력하기 b나올듯

        Deque<String> queue = new ArrayDeque<>(); // 디큐로 큐만들기
        queue.offer("C"); //  c넣기 오퍼가 뭐지
        queue.offer("D"); //d넣기
        System.out.println("④ queue poll = " + queue.poll()); // c가 나올거같아

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위큐 만들기
        pq.offer(50); // 50넣기 0번
        pq.offer(10); // 10넣기 0번 들어가고 50 밀림
        pq.offer(30); // 30넣기 1번 등러가고 50밀림
        System.out.println("⑤ 그냥 출력 = " + pq); // [10, 30, 50]

        System.out.print("⑤ poll 순서 = ");
        while (!pq.isEmpty()){ //와일뭉닌데 이제 이스엠티가 내기엄으로 비었는지 확인하는건데 조건에 들어간거보니까
            System.out.print(pq.poll() + " "); // 폴이 확실하지는 않지만 하나씩 빼는 메소드일거같아 그래서 출력하는
        }
        System.out.println();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); //이것도 우선순위 큐인가
        maxHeap.addAll(List.of(50,10,30)); //애드올이라길래 원소 여러개를 한번에 넣는건가? 생각했는데 리스트로넣네 뭐지
        System.out.print("⑤ 최대힙 = ");
        while (!maxHeap.isEmpty()) { // 위에랄 똑같은 설명으로
            System.out.print(maxHeap.poll() + " ");
        }

    }
}
