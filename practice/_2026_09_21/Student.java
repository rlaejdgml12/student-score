package _2026_09_21;

public record Student(long id, String name, int score) {
    public Student{
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }
        if(score < 0 || score > 100){
            throw new IllegalArgumentException("점수는 0 ~ 100입니다.");
        }
    }

    public String grade(){
        if(score >= 90) return "A";
        if(score >= 80) return "B";
        if(score >= 70) return "C";
        if(score >= 60) return "D";
        return "F";
    }
}
