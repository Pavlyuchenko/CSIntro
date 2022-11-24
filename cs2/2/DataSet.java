public class DataSet {
    private double sum;
    private Object maximum;
    private int count;
    private Measurer measurer;
    private Filter filter;

    public DataSet(Measurer measurer, Filter filter) {
        this.sum = 0;
        this.count = 0;
        this.maximum = null;
        this.measurer = measurer;
        this.filter = filter;
    }

    public void add(Object x) {
        if (filter.accept(x)) {
            sum = sum + measurer.measure(x);
            if ((count == 0 || measurer.measure(maximum) < measurer.measure(x)))
                maximum = x;
            count++;
        }
    }

    public double getAverage() {
        if (count == 0)
            return 0;
        else
            return sum / count;
    }

    public Object getMaximum() {
        return maximum;
    }

    public static void main(String[] args) {
        Car car1 = new Car(0.1);
        Car car2 = new Car(0.1);
        Car car3 = new Car(0.1);

        car1.addFuel(100);
        car2.addFuel(3);
        car3.addFuel(200);

        CarMeasurer cm = new CarMeasurer();
        CarFilter cf = new CarFilter();

        DataSet ds = new DataSet(cm, cf);
        ds.add(car1);
        ds.add(car2);
        ds.add(car3);

        System.out.println(ds.getAverage());
    }

}

class CarMeasurer implements Measurer {
    public double measure(Object anObject) {
        if (anObject instanceof Car) {
            Car car = (Car) anObject;
            return car.getFuel();
        }
        return 0;
    }
}

class CarFilter implements Filter {
    public boolean accept(Object x) {
        if (x instanceof Car) {
            Car car = (Car) x;
            if (car.canDrive(100)) {
                return true;
            }
        }
        return false;
    }
}