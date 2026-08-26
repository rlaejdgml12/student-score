package studentscore.domain.student;

import java.util.Objects;
import java.util.List;

public class Student {
    private final String name;
    private final int korScore;
    private final int mathScore;
    private final int engScore;
    private final List<String> subjects;

    public static final int SUBJECT_COUNT = 3;
    public static final int MAX_SCORE = 100;
    public static final int SCHOLARSHIP_THRESHOLD = 280;

    public Student(String name, int korScore, int mathScore, int engScore){
        this(name, korScore, mathScore, engScore, List.of("국어", "수학", "영어"));
    }

    public Student(String name, int korScore, int mathScore, int engScore, List<String> subjects) {
        this.name = name;
        this.korScore = korScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
        this.subjects = List.copyOf(subjects);
    }

    public String getName(){
        return this.name;
    }

    public int getKorScore(){
        return this.korScore;
    }

    public int getMathScore(){
        return this.mathScore;
    }

    public int getEngScore(){
        return this.engScore;
    }

    public List<String> getSubjects(){
        return this.subjects;
    }

    public int totalScore() {
        return this.korScore + this.mathScore + this.engScore;
    }

    public double averageScore() {
        return this.totalScore() / (double)SUBJECT_COUNT;
    }

    public boolean isScholarship(){
        return this.totalScore() >= SCHOLARSHIP_THRESHOLD;
    }

    public Grade getGrade(){
        return Grade.of(averageScore());
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return other.korScore == this.korScore && other.mathScore == this.mathScore && other.engScore == this.engScore && other.name.equals(this.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, korScore, mathScore, engScore);
    }

    @Override
    public String toString(){
        return name + "(" + String.format("%.1f", this.averageScore()) + ")";
    }

}
