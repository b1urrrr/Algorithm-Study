package chap01.practice;

public class Practice1_4 {
    static int med(int a, int b, int c) {
        if (a >= b)
            if (b >= c)
                return b;
            else if (c >= a)
                return a;
            else
                return c;
        else
            if (a >= c)
                return a;
            else if (c >= b)
                return b;
            else
                return c;
    }

    public static void main(String[] args) {
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    System.out.printf("med(%d, %d, %d) = %d\n", a, b, c, med(a, b, c));
                }
            }
        }
    }
}
