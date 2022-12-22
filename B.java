class A {
    protected double x;

    public A(double y) {
        x = y;
    }

}

public class B extends A {
    public B(double y) {
        super(y);
    }

    public B() {
        this(0);
    }

    public static void main(String[] args) {
        System.out.println(new B().x);
    }
}
