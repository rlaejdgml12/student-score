package domain;

public class Student {
    String name;
    int korScore;
    int mathScore;
    int engScore;

    public Student(){
        this("이름없음", 0, 0, 0);
    }

    public Student(String name, int korScore, int mathScore, int engScore){
        this.name = name;
        this.korScore = korScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    public String getName(){
        return name;
    }

    public int getTotal(){
        return korScore + mathScore + engScore;
    }

    public double getAverage(){
        return getTotal() / 3.0;
    }
}
