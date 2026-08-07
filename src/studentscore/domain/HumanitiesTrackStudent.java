package studentscore.domain;

public class HumanitiesTrackStudent extends Student{
    public HumanitiesTrackStudent(String name, int korScore, int mathScore, int engScore){
        super(name, korScore, mathScore, engScore);
    }

    @Override
    public int totalScore(){
        int kor = Math.min((int)(this.getKorScore() * 1.1), 100);
        int math = this.getMathScore();
        int eng = Math.min((int)(this.getEngScore() * 1.1), 100);
        return kor + math + eng;
    }
}
