public class Car {
    private double efficiency;
    private double fuel = 0;

    static int motorNumber = 1;
    private int motor;

    static String fuelAdded = "";

    public Car(double efficiency) {
        this.efficiency = efficiency;
        this.motor = motorNumber;
        motorNumber++;
    }

    public boolean canDrive(double distance) {
        return this.fuel / this.efficiency >= distance;
    }

    public void drive(double distance) {
        if (canDrive(distance)) {
            this.fuel -= distance * this.efficiency;
        }
    }

    public double getFuel() {
        return this.fuel;
    }

    public void addFuel(double fuel) {
        this.fuel += fuel;

        fuelAdded += "Car Motor Number " + this.motor + ": " + fuel + " liters\n";
    }

    public static String fuelRefills() {
        return fuelAdded;
    }

    public static void main(String[] args) {
        Car car1 = new Car(0.1);
        Car car2 = new Car(0.1);
        Car car3 = new Car(0.1);
        Car car4 = new Car(0.1);
        car1.addFuel(40);
        car2.addFuel(100);
        car3.addFuel(4010);
        car1.addFuel(120);
        car4.addFuel(320);

        System.out.print(Car.fuelRefills());
    }

}