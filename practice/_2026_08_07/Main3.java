package _2026_08_07;

interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();
}

class Duck implements Flyable, Swimmable{
    @Override
    public void fly(){
        System.out.println("날기");
    }
    @Override
    public void swim(){
        System.out.println("수영");
    }
}

public class Main3 {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
    }
}
