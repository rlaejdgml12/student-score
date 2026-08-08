package _2026_08_08;

import java.util.HashSet;
import java.util.Set;
import studentscore.domain.Student;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("김철수", 90, 90, 90));
        students.add(new Student("김철수", 90, 90, 90));
        System.out.println(students.size());
    }

}
