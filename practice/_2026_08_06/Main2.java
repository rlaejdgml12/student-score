package _2026_08_06;

class Printer {

    void print(String value){
        System.out.println("문자열 : " + value);
    }

    void print(int value){
        System.out.println("정수 : " + value);
    }

    void print(String value, int count){
        for(int i = 0; i < count; i++){
            System.out.println(value);
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print("hello");
        printer.print(10);
        printer.print("java", 3);
    }
}
