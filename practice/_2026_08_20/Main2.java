package _2026_08_20;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {

    static class Student{
        private final String name;
        private final int score;

        Student(String name, int score){
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString(){return name + ":" + score;}
    }

    public static void main(String[] args) {
        Set<String> hash = new HashSet<>();
        Set<String> linked = new LinkedHashSet<>();
        Set<String> tree = new TreeSet<>();

        for(String s : List.of("B", "A", "C", "A")){ //그냥 리스트 원소를 차례대로 각 셋에 넣는거
            hash.add(s);
            linked.add(s);
            tree.add(s);
        }
        System.out.println("① hash   = " + hash);
        System.out.println("① linked = " + linked);
        System.out.println("① tree   = " + tree);

        Set<Student> broken = new TreeSet<>(
                Comparator.comparingInt(s -> s.score)); //트리셋인데 점수순으로 정렬
        broken.add(new Student("kim", 90));
        broken.add(new Student("lee", 90));
        System.out.println("② broken = " + broken); //이러면 점수만봐서 중복이라고 판단하고 제거됨

        Set<Student> fixed = new TreeSet<>(
                Comparator.comparingInt((Student s) -> s.score)
                        .thenComparing(s -> s.name) // 점수중복이면 2순위로 이름순 정렬
        );
        fixed.add(new Student("kim", 90));
        fixed.add(new Student("lee", 90));
        System.out.println("② fixed  = " + fixed); //둘다 잘들어감

        NavigableSet<Integer> scores = new TreeSet<>(List.of(70, 80, 90, 100));

        System.out.println("③ first   = " + scores.first());   //이건 뭐야 제일 작은건가
        System.out.println("③ higher(80) = " + scores.higher(80)); //80 초과 90 출력
        System.out.println("③ ceiling(80)= " + scores.ceiling(80)); // 이건 이상아닌가 80 출력
        System.out.println("③ higher(100)= " + scores.higher(100)); // 100초과인데 100넘는게 없어서 x
        System.out.println("③ tailSet(80)= " + scores.tailSet(80)); // 80이상 전부

        NavigableSet<Integer> head = scores.headSet(90, true); //이건 뭐야 모르겟는데
        head.remove(80);
        System.out.println("③ 원본 = " + scores);

    }

}
