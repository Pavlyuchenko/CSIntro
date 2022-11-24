public class Car {
    private double fuel = 0;
    private double efficiency;

    public Car(double efficiency) {
        this.efficiency = efficiency;
        this.fuel = 0;
    }

    public void drive(double distance) {
        if (this.canDrive(distance)) {
            fuel -= distance * this.efficiency;
        }
    }

    public boolean canDrive(double distance) {
        if (this.fuel >= this.efficiency * distance) {
            return true;
        }
        return false;
    }

    public double getFuel() {
        return this.fuel;
    }

    public void addFuel(double fuel) {
        this.fuel += fuel;
    }

}
