package domain;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public void printAll(){
        for (Student s : students){
            s.introduce();
        }
    }

    public double getClassAverage() {
        double sum = 0.0;
        for (Student s : students) {
            sum += s.getAverage();
        }
        return sum / students.size();
    }
}
