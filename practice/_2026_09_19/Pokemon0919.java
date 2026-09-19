package _2026_09_19;

import java.util.HashSet;
import java.util.Set;

/*
 * 프로그래머스 1845 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *
 * 코테 07 해시맵·해시셋 — 백준 10815(숫자 카드) 대체 문제
 * 풀이: 종류 가짓수(HashSet.size)와 N/2 중 작은 쪽
 * 복잡도: O(N)
 */
public class Pokemon0919 {

    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> types = new HashSet<>();
        for (int s : nums) {
            types.add(s);
        }
        answer = types.size() > nums.length / 2 ? nums.length / 2 : types.size();
        return answer;
    }

    public static void main(String[] args) {
        Pokemon0919 s = new Pokemon0919();
        System.out.println(s.solution(new int[]{3, 1, 2, 3}));          // 2
        System.out.println(s.solution(new int[]{3, 3, 3, 2, 2, 4}));    // 3
        System.out.println(s.solution(new int[]{3, 3, 3, 2, 2, 2}));    // 2
    }
}
