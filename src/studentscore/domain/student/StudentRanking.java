package studentscore.domain.student;

import java.util.*;


public class StudentRanking {
    public static List<Student> rankByAverage(List<Student> students){
        List<Student> ranked = new ArrayList<>(students);
        ranked.sort(Comparator.comparingDouble(Student::averageScore).reversed().thenComparing(Student::getName));
        return ranked;
    }

    public static Map<Grade, List<Student>> groupByGrade(List<Student> students){
        Map<Grade, List<Student>> ranked = new HashMap<>();
        for(Student s : students){
            ranked.computeIfAbsent(s.getGrade(), k -> new ArrayList<>()).add(s);
        }
        return ranked;
    }

}
