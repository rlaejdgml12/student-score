package studentscore.domain;

public class DetailedReportPrinter implements ReportPrinter {
    @Override
    public void print(Student student) {
        System.out.println("이름 : " + student.getName() + ", 국어 점수 : " + student.getKorScore() + ", 수학 점수 : " + student.getMathScore() + ", 영어 점수 : " + student.getEngScore() + ", 총점 : " + student.totalScore() + ", 평균 : " + student.averageScore() + ", 장학생 여부 : " + student.isScholarship());
    }
}
