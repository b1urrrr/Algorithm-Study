package chap07;

class A {

}

class B {
    int x;

    B(int x) { this.x = x; }

    public String toString() { return "B[" + x + "]"; }
}

public class ToStringTester {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        B b1 = new B(18);
        B b2 = new B(55);

        System.out.println("a1 = " + a1.toString());
        System.out.println("a2 = " + a2);
        System.out.println("b1 = " + b1.toString());
        System.out.println("b2 = " + b2);
    }
}
