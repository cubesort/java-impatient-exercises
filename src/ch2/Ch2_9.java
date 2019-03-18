package ch2;

public class Ch2_9 {
    public static void main(String[] args) {
        Car car = new Car();
        car.move(100);
        System.out.println(car.getGas());
        System.out.println(car.getLocation());
        car.addGas(10);
        System.out.println(car.getGas());
        System.out.println(car.getLocation());
    }
}

class Car {
    private final int milePerGallon;
    private int location;
    private int gas = 100;

    public Car() {
        this.milePerGallon = 20;
    }

    public Car(int milePerGallon) {
        this.milePerGallon = milePerGallon;
    }

    public void move(int distance) {
        this.location += distance;
        this.gas -= distance / milePerGallon;
    }

    public int getGas() {
        return gas;
    }

    public int getLocation() {
        return location;
    }

    public void addGas(int gas) {
        this.gas += gas;
    }
}
