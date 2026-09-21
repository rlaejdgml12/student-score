package _2026_09_21;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StudentStats0921 {

    // 드릴용 샘플 데이터 (그대로 쓰시면 됩니다)
    static final List<Student> STUDENTS = List.of(
            new Student(1L, "김동희", 92),
            new Student(2L, "이서준", 87),
            new Student(3L, "박지민", 92),
            new Student(4L, "최유진", 58),
            new Student(5L, "정민수", 74),
            new Student(6L, "강하늘", 60),
            new Student(7L, "윤서아", 45),
            new Student(8L, "임재현", 81)
    );

    public static List<String> passedNames(List<Student> students){
        return students.stream()
                .filter(s -> s.score() >= 60)
                .map(Student::name)
                .sorted()
                .toList();
    }

    public static List<Student> topThree(List<Student> students){
        return students.stream()
                .sorted(Comparator.comparingInt(Student::score).reversed()
                        .thenComparing(Student::name))
                .limit(3)
                .toList();
    }

    public static OptionalDouble average(List<Student> students) {
        return students.stream()
                .mapToInt(Student::score)
                .average();
    }

    public static Optional<Student> highest(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingInt(Student::score));
    }

    private static Student makeDefault(){
        System.out.println("makedDefault 호출");
        return new Student(0, "기본", 0);
    }

    public static void main(String[] args) {
        System.out.println(passedNames(STUDENTS));
        System.out.println(topThree(STUDENTS));
        average(STUDENTS).ifPresentOrElse(
                avg -> System.out.println("평군 : " + avg),
                () -> System.out.println("아직 응시자가 없습니다.")
        );
        System.out.println(highest(STUDENTS));

        System.out.println("--- orElse ---");
        highest(STUDENTS).orElse(makeDefault());

        System.out.println("--- orElseGet ---");
        highest(STUDENTS).orElseGet(StudentStats0921::makeDefault);
    }
}
