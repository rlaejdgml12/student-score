package studentscore;

class Student {
    String name;
    int korScore;
    int mathScore;
    int engScore;

    Student(String name, int korScore, int mathScore, int engScore) {
        this.name = name;
        this.korScore = korScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    public int totalScore() {
        return this.korScore + this.mathScore + this.engScore;
    }

    public double averageScore() {
        return this.totalScore() / 3.0;
    }
}
