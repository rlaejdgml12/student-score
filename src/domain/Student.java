package domain;

public class Student {
    static final int MAX_SCORE = 100;
    static final int MIN_SCORE = 0;

    private String name;
    private int korScore;
    private int mathScore;
    private int engScore;

    public Student(){
        this("이름없음", 0, 0, 0);
    }

    public Student(String name, int korScore, int mathScore, int engScore){
        this.name = name;
        setKorScore(korScore);
        setMathScore(mathScore);
        setEngScore(engScore);
    }

    public void setKorScore(int korScore){
        if (korScore > MAX_SCORE || MIN_SCORE > korScore){
            throw new IllegalArgumentException("점수는 0 ~ 100 사이여야 합니다 : " + korScore);
        }
        this.korScore = korScore;
    }

    public void setMathScore(int mathScore){
        if (mathScore > MAX_SCORE || MIN_SCORE > mathScore){
            throw new IllegalArgumentException("점수는 0 ~ 100 사이여야 합니다 : " + mathScore);
        }
        this.mathScore = mathScore;
    }

    public void setEngScore(int engScore){
        if (engScore > MAX_SCORE || MIN_SCORE > engScore){
            throw new IllegalArgumentException("점수는 0 ~ 100 사이여야 합니다 : " + engScore);
        }
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
