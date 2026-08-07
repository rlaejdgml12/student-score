package studentscore.domain;

public class SimpleReportPrinter implements ReportPrinter {
    @Override
    public void print(Student student) {
        System.out.println("이름 : " + student.getName() + ", 총점 : " + student.totalScore());
    }
}
