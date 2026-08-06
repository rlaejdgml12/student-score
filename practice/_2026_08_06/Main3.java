package _2026_08_06;

class Calculator{
    public int add(int value1, int value2){
        return value1 + value2;
    }

    public double add(double value1, double value2){
        return value1 + value2;
    }

    public int add(int value1, int value2, int value3){
        return value1 + value2 + value3;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(1,2));
        System.out.println(cal.add(1.1,2.2));
        System.out.println(cal.add(1,2,3));
    }
}
