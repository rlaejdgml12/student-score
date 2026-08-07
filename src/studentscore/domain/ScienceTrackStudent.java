package studentscore.domain;

public class ScienceTrackStudent extends Student {
    public ScienceTrackStudent(String name, int korScore, int mathScore, int engScore){
        super(name, korScore, mathScore, engScore);
    }

    @Override
    public int totalScore(){
        int kor = this.getKorScore();
        int math = Math.min((int)(this.getMathScore()*1.1), 100);
        int eng = this.getEngScore();
        return kor + math + eng;
    }
}
