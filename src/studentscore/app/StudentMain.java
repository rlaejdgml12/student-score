package studentscore.app;

import studentscore.domain.printer.DetailedReportPrinter;
import studentscore.domain.printer.ReportPrinter;
import studentscore.domain.printer.ReportService;
import studentscore.domain.printer.SimpleReportPrinter;
import studentscore.domain.student.HumanitiesTrackStudent;
import studentscore.domain.student.ScienceTrackStudent;
import studentscore.domain.student.Student;

public class StudentMain {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("짱구", 90, 85, 100);
        students[1] = new ScienceTrackStudent("철수", 85, 100, 94);
        students[2] = new HumanitiesTrackStudent("유리", 80, 100, 100);

        ReportPrinter printer = new SimpleReportPrinter();
        ReportService service = new ReportService(printer);

        for(int i = 0; i < students.length; i++){
            service.printReport(students[i]);
        }

        ReportPrinter printer1 = new DetailedReportPrinter();
        ReportService service1 = new ReportService(printer1);

        for(int i = 0; i < students.length; i++){
            service1.printReport(students[i]);
        }

    }
}
