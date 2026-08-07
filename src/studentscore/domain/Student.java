package studentscore.domain;

public class Student {
    private String name;
    private int korScore;
    private int mathScore;
    private int engScore;

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
        return this.totalScore() / 3.0;
    }
}
