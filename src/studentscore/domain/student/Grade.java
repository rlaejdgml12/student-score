package studentscore.domain.student;

public enum Grade{
    A {boolean matches(double average) {return average >= 90;}},
    B {boolean matches(double average) {return average >= 80;}},
    C {boolean matches(double average) {return average >= 70;}},
    D {boolean matches(double average) {return average >= 60;}},
    F {boolean matches(double average) {return true;}};

    abstract boolean matches(double average);

    static Grade of(double average){
        for(Grade grade : values()){
            if(grade.matches(average)){
                return grade;
            }
        }
        throw new IllegalArgumentException("등급을 찾을 수 없습니다.");
    }
}