package studentscore.app;

import studentscore.domain.printer.DetailedReportPrinter;
import studentscore.domain.printer.ReportPrinter;
import studentscore.domain.printer.ReportService;
import studentscore.domain.printer.SimpleReportPrinter;
import studentscore.domain.student.HumanitiesTrackStudent;
import studentscore.domain.student.ScienceTrackStudent;
import studentscore.domain.student.Student;
import studentscore.domain.student.StudentFileReader;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {

        List<Student> students = StudentFileReader.readAll("students.txt");

        ReportPrinter printer = new SimpleReportPrinter();
        ReportService service = new ReportService(printer);

        for(int i = 0; i < students.size(); i++){
            service.printReport(students.get(i));
        }

        ReportPrinter printer1 = new DetailedReportPrinter();
        ReportService service1 = new ReportService(printer1);

        for(int i = 0; i < students.size(); i++){
            service1.printReport(students.get(i));
        }

    }
}
