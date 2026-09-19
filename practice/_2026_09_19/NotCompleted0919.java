package _2026_09_19;

import java.util.HashMap;
import java.util.Map;

/*
 * 프로그래머스 42576 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 코테 07 해시맵·해시셋 — 백준 7785(회사에 있는 사람) 대체 문제
 * 풀이: 참가자를 Map에 세어 담고, 완주자로 하나씩 덜어낸다. 0이 아닌 키가 답
 * 동명이인 때문에 HashSet으로는 풀리지 않는다 (개수를 잃음)
 * 복잡도: O(N)
 */
public class NotCompleted0919 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();
        for (String s : participant) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            count.put(s, count.getOrDefault(s, 0) - 1);
        }
        for (String s : count.keySet()) {
            if (count.get(s) != 0) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        NotCompleted0919 s = new NotCompleted0919();
        System.out.println(s.solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));                          // leo
        System.out.println(s.solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));               // mislav
    }
}
