package _2026_08_20;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Main3 {
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

        for(String s : List.of("B", "A", "C", "A")){
            hash.add(s);
            linked.add(s);
            tree.add(s);
        }

        System.out.println("hash: " + hash);
        System.out.println("linked: " + linked);
        System.out.println("tree: " + tree);

        Set<Student> broken = new TreeSet<>(
                Comparator.comparingInt(s -> s.score));
        broken.add(new Student("kim", 90));
        broken.add(new Student("lee", 90));
        System.out.println("broken : " + broken);

        Set<Student> fixed = new TreeSet<>(
                Comparator.comparingInt((Student s) -> s.score)
                                .thenComparing(s -> s.name));
        fixed.add(new Student("kim", 90));
        fixed.add(new Student("lee", 90));
        System.out.println("fixed : " + fixed);

        NavigableSet<Integer> score = new TreeSet<>(List.of(70, 80, 90, 100));
        System.out.println("가장 작은 값 : " +score.first());
        System.out.println("80보다 큰 값 중 가장 가까운 것 : " + score.higher(80));
        System.out.println("80 이상인 값 중 가장 가까운 것 : " + score.ceiling(80));
        System.out.println("100보다 큰 값 중 가장 가까운 것 : " + score.higher(100));
        System.out.println("80이상이 값 전부 : " + score.tailSet(80));

        NavigableSet<Integer> score2 = new TreeSet<>(score.headSet(90, true));
        score2.remove(80);
        System.out.println(score2);

    }
}
