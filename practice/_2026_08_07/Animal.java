package _2026_08_07;

abstract class Animal {
    abstract void sound();
    public void move(){
        System.out.println("이동합니다");
    }
}

class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("멍");
    }
}

class Cat extends Animal{
    @Override
    public void sound(){
        System.out.println("냥");
    }
}
