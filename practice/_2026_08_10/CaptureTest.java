package _2026_08_10;

import java.util.ArrayList;
import java.util.List;

public class CaptureTest {

    public static void main(String[] args) {
        workingVersion();
    }

    static void workingVersion(){
        List<Runnable> tasks = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            int taskId = i;
            tasks.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task : " + taskId);
                }
            });
        }

        for(Runnable task : tasks){
            task.run();
        }

    }

    static void brokenVersion() {
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            tasks.add(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(i);
                    // 컴파일 오류: local variables referenced from an inner class
                    // must be final or effectively final
                }
            });
        }

        for (Runnable task : tasks) {
            task.run();
        }
    }
}
