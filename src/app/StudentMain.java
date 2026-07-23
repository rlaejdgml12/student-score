package app;

import domain.HonorStudent;
import domain.Student;
import domain.StudentFactory;
import domain.StudentManager;

public class StudentMain {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(StudentFactory.create("홍길동", 80, 75, 88));
        manager.addStudent(StudentFactory.create("김동희", 90, 95, 89));
        manager.printAll();
        System.out.println("학급 전체 평균 : " + manager.getClassAverage());
    }
}
