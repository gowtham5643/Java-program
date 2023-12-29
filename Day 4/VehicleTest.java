
package placement_training;
class Vehicle {
    private double speed;
    public Vehicle(double speed) {
        this.speed = speed;
    }
    public double calculateSpeed() {
        return speed;
    }
}
class Car extends Vehicle {
    private int numberOfPassengers;
    public Car(double speed, int numberOfPassengers) {
        super(speed);
        this.numberOfPassengers = numberOfPassengers;
    }
    @Override
    public double calculateSpeed() {
        return super.calculateSpeed() * numberOfPassengers;
    }
}
class Motorcycle extends Vehicle {
    private int numberOfWheels;
    public Motorcycle(double speed, int numberOfWheels) {
        super(speed);
        this.numberOfWheels = numberOfWheels;
    }
    @Override
    public double calculateSpeed() {
        return super.calculateSpeed() * numberOfWheels;
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Car car = new Car(100, 4);
        Motorcycle motorcycle = new Motorcycle(120, 2);
        double carSpeed = car.calculateSpeed();
        double motorcycleSpeed = motorcycle.calculateSpeed();
        String fastestVehicle;
        if (carSpeed > motorcycleSpeed) {
            fastestVehicle = "Car";
        } else if (carSpeed < motorcycleSpeed) {
            fastestVehicle = "Motorcycle";
        } else {
            fastestVehicle = "Both vehicles have the same speed";
        }
        System.out.println("Car Speed: " + carSpeed);
        System.out.println("Motorcycle Speed: " + motorcycleSpeed);
        System.out.println("The vehicle with the highest effective speed is: " + fastestVehicle);
        System.out.println("No car is better than BMW");
    }
}
