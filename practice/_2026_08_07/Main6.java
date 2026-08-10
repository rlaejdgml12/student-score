package _2026_08_07;

interface Car {
    void startEngine();
    void pressAccelerator();
}

class K3Car implements Car{
    @Override
    public void startEngine() {
        System.out.println("K3 시동");
    }
    @Override
    public void pressAccelerator() {
        System.out.println("K3 가속");
    }
}

class Model3Car implements Car {
    @Override
    public void startEngine() {
        System.out.println("Model3 시동");
    }
    @Override
    public void pressAccelerator() {
        System.out.println("Model3 가속");
    }
}

class Driver{
    private final Car car;

    public Driver(Car car){
        this.car = car;
    }

    public void drive(){
        car.startEngine();
        car.pressAccelerator();
    }
}

public class Main6 {
    public static void main(String[] args) {
        Car car = new K3Car();
        Driver driver = new Driver(car);
        driver.drive();

        Car newCar = new Model3Car();
        Driver newDriver = new Driver(newCar);
        newDriver.drive();
    }

}
