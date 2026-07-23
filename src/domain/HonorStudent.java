package domain;

public class HonorStudent extends Student {

    public HonorStudent() {
        this("이름없음", 0, 0, 0);
    }

    public HonorStudent(String name, int korScore, int mathScore, int engScore) {
        super(name, korScore, mathScore, engScore);
    }

    public void introduce(){
        System.out.println("이름 : " + getName() + "(장학생), 평균 : " + getAverage());
    }
}
