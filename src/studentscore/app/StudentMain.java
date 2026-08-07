package studentscore.app;

import studentscore.domain.Student;

public class StudentMain {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("짱구", 90, 85, 100);
        students[1] = new Student("철수", 85, 100, 94);
        students[2] = new Student("유리", 80, 100, 100);

        for(int i = 0; i < students.length; i++){
            System.out.println("이름 : " + students[i].getName() + ", 총점 : " + students[i].totalScore() + ", 평균 : " + students[i].averageScore());
        }
    }
}
