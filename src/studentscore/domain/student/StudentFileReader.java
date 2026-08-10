package studentscore.domain.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentFileReader {

    public static List<Student> readAll(String filepath){
        List<Student> students = new ArrayList<>();

        try(BufferedReader reader = Files.newBufferedReader(Path.of(filepath), StandardCharsets.UTF_8)){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                String name = parts[0];
                int kor = Integer.parseInt(parts[1]);
                int math = Integer.parseInt(parts[2]);
                int eng = Integer.parseInt(parts[3]);

                Student student = new Student(name, kor, math, eng);
                students.add(student);
            }
        } catch (IOException e){
            throw new StudentDataException("학생 정보가 잘못되었습니다. : " + filepath, e);
        }
        return students;
    }

}
