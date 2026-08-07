package _2026_08_07;

class Data{
    int value;
}

public class Main2 {
    public static void main(String[] args) {
        final Data data = new Data();
        System.out.println(data.value);
        data.value = 10;
        System.out.println(data.value);
    }
}
