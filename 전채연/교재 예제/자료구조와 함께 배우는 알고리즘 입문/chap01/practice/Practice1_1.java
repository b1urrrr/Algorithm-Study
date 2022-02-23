package chap01.practice;

public class Practice1_1 {
    // Q1
    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }

    // Q2
    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    // Q3
    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        return min;
    }
    public static void main(String[] args) {
        System.out.println("max4(7, 3, 9, 2) = " + max4(7, 3, 9, 2));
        System.out.println("min3(7, 3, 9) = " + min3(7, 3, 9));
        System.out.println("min4(7, 3, 9, 2) = " + min4(7, 3, 9, 2));
    }    
}
