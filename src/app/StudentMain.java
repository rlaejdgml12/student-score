package app;

import domain.HonorStudent;
import domain.Student;
import domain.StudentFactory;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = StudentFactory.create("홍길동", 80, 75, 88);
        Student student2 = StudentFactory.create("김동희", 90, 95, 89);

        student1.introduce();
        student2.introduce();
    }
}
