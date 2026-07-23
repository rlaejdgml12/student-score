package app;

import domain.Student;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student("김동희", 100, 85, 78);

        Student student2 = new Student("홍길동", 80, 75, 88);

        System.out.println(student1.getName() + ", 총점 : " + student1.getTotal() + ", 평균 : " + student1.getAverage());
        System.out.println(student2.getName() + ", 총점 : " + student2.getTotal() + ", 평균 : " + student2.getAverage());
    }
}
