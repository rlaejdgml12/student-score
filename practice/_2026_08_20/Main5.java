package _2026_08_20;

import java.util.*;

public class Main5 {

    static class Student implements Comparable<Student>{
        private final String name;
        private final int score;

        Student(String name, int score){
            this.name = name;
            this.score = score;
        }

        public String getName() { return name; }
        public int getScore() { return score; }

        @Override
        public int compareTo(Student other){
            return Integer.compare(this.score, other.score);
        }

        @Override
        public String toString() { return name + "(" + score + ")"; }
    }

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>(List.of("A", "B", "C"));
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            if (it.next().equals("B")){
                it.remove();
            }
            System.out.println("① " + list1);

            List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
            list2.removeIf(n -> n % 2 == 0);
            System.out.println("② " + list2);

            List<Student> students = new ArrayList<>();
            students.add(new Student("kim", 90));
            students.add(new Student("lee", 90));
            students.add(new Student("park", 70));

            students.sort(null);
            System.out.println("③ " + students);

            students.sort(Comparator.comparing(Student::getName));
            System.out.println("④ " + students);

            students.sort(Comparator.comparingInt(Student::getScore).reversed().thenComparing(Student::getName));
            System.out.println("⑤ " + students);

            int[] arr = {3, 1, 2};
            Arrays.sort(arr);
            System.out.println("⑥ " + Arrays.toString(arr));

            List<String> fixed = Arrays.asList("A", "B");
            fixed.set(0, "Z");
            System.out.println("⑦ " + fixed);

            try {
                fixed.add("C");
            } catch (UnsupportedOperationException e) {
                System.out.println("⑦ add는 예외: " + e.getClass().getSimpleName());
            }

        }

    }

}
