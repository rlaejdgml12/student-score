package studentscore.app;

import studentscore.domain.printer.DetailedReportPrinter;
import studentscore.domain.printer.ReportPrinter;
import studentscore.domain.printer.ReportService;
import studentscore.domain.printer.SimpleReportPrinter;
import studentscore.domain.student.HumanitiesTrackStudent;
import studentscore.domain.student.ScienceTrackStudent;
import studentscore.domain.student.Student;
import studentscore.domain.student.StudentFileReader;
import studentscore.domain.student.Grade;
import studentscore.domain.student.StudentRanking;

import java.util.Map;
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

        System.out.println("===== 성적 순위 =====");
        List<Student> ranked = StudentRanking.rankByAverage(students);
        for (int i = 0; i < ranked.size(); i++) {
            System.out.println((i + 1) + "등 " + ranked.get(i));
        }

        System.out.println("===== 등급별 =====");
        Map<Grade, List<Student>> byGrade = StudentRanking.groupByGrade(students);
        for (Grade grade : byGrade.keySet()) {
            System.out.println(grade + " : " + byGrade.get(grade));
        }

    }
}
