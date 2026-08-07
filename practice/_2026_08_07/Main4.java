package _2026_08_07;

public class Main4 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog();
        animals[1] = new Cat();

        for (Animal a : animals) {
            a.move();
            a.sound();
        }
    }
}
