package studentscore.domain.student;

public class StudentDataException extends RuntimeException {
    public StudentDataException(String message){
        super(message);
    }

    public StudentDataException(String message, Throwable cause){
        super(message, cause);
    }
}
