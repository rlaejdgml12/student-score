package studentscore.domain.printer;


import studentscore.domain.student.Student;

public class ReportService {
    private final ReportPrinter printer;

    public ReportService(ReportPrinter printer){
        this.printer = printer;
    }

    public void printReport(Student student){
        printer.print(student);
    }
}
