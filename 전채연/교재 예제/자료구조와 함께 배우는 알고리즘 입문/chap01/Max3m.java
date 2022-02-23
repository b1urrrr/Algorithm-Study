package chap01;

public class Max3m {
    static void max3(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (max == 3) System.out.printf("max3(%d,%d,%d) = %d\n", a, b, c, max);
    }
    public static void main(String[] args) {
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    max3(a, b, c);
                }
            }
        }
    }
}