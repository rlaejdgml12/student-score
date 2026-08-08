package _2026_08_08;

import java.util.ArrayList;
import java.util.List;

final class CourseInfo{
    private final String courseName;
    private final List<String> topics;

    public CourseInfo(String courseName, List<String> topics){
        this.courseName = courseName;
        this.topics = List.copyOf(topics);
    }

    public List<String> getTopics(){
        return this.topics;
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<String> topics2 = new ArrayList<>();
        topics2.add("윤현서");
        CourseInfo info = new CourseInfo("윤현서", topics2);
        topics2.add("윤현서2");
        System.out.println(info.getTopics());
        info.getTopics().add("해킹시도");
    }
}
