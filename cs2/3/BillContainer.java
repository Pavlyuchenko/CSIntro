import java.util.ArrayList;

public class BillContainer {
    private ArrayList<Bill> bills;

    public BillContainer() {
        this.bills = new ArrayList<Bill>();
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public double totalFee() {
        double total = 0;
        for (Bill bill : bills) {
            total += bill.getAmountDue();
        }

        return total;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(" + this.totalFee() + ")";
    }

    public static void main(String[] args) {
        Doctor doc1 = new Doctor("Dr. House", 54, "Smart guy", 200);
        Doctor doc2 = new Doctor("Luuk", 21, "The Programmer", 100);

        Patient pat1 = new Patient("Michal Pavlíček", 19, "M13");
        Patient pat2 = new Patient("Viktor Istrati", 19, "V11");

        Bill bill1 = new Bill(pat1, doc1);
        Bill bill2 = new Bill(pat1, doc2);
        Bill bill3 = new Bill(pat2, doc1);
        Bill bill4 = new Bill(pat2, doc2);

        BillContainer bc = new BillContainer();

        bc.addBill(bill1);
        bc.addBill(bill2);
        bc.addBill(bill3);
        bc.addBill(bill4);

        System.out.println(bc);
    }
}
