import java.util.ArrayList;

public class ShoppingBag {

    public static class Product implements Item {
        private String name;
        private double price;
        private String bioInfo;

        public Product(String name, double price, String bioInfo) {
            this.name = name;
            this.price = price;
            this.bioInfo = bioInfo;
        }

        public String getName() {
            return this.name;
        }

        public double getPrice() {
            return this.price;
        }
    }

    private ArrayList<Item> bag;

    public ShoppingBag() {
        this.bag = new ArrayList<Item>();
    }

    public void add(Item item) {
        bag.add(item);
    }

    public double totalPriceForProduct(String name) {
        double result = 0;
        for (Item item : bag) {
            if (item.getName() == name) {
                result += item.getPrice();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ShoppingBag bag = new ShoppingBag();
        Product milk = new Product("Milk", 0.95, "A milk");
        Product stroopWafel = new Product("Stroopwafel", 2.21, "A stroopwafel");

        bag.add(milk);
        bag.add(milk);
        bag.add(stroopWafel);

        System.out.println(bag.totalPriceForProduct("Milk"));
    }
}