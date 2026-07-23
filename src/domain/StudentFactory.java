package domain;

public class StudentFactory {
    public static Student create(String name, int korScore, int mathScore, int engScore) {
        double avg = (korScore + mathScore + engScore) / 3;
        if (avg >= 90) {
            return new HonorStudent(name, korScore, mathScore, engScore);
        } else {
            return new Student(name, korScore, mathScore, engScore);
        }
    }
}
