package studentscore.domain;

public class Student {
    private final String name;
    private final int korScore;
    private final int mathScore;
    private final int engScore;

    public static final int SUBJECT_COUNT = 3;
    public static final int MAX_SCORE = 100;
    public static final int SCHOLARSHIP_THRESHOLD = 280;

    public Student(String name, int korScore, int mathScore, int engScore) {
        this.name = name;
        this.korScore = korScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
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

    public int totalScore() {
        return this.korScore + this.mathScore + this.engScore;
    }

    public double averageScore() {
        return this.totalScore() / (double)SUBJECT_COUNT;
    }

    public boolean isScholarship(){
        return this.totalScore() >= SCHOLARSHIP_THRESHOLD;
    }
}
