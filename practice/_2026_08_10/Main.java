package _2026_08_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = Files.newBufferedReader(Path.of("score.txt"), StandardCharsets.UTF_8)){
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e){
            System.out.println("값 입력 실패");
        }
    }
}
