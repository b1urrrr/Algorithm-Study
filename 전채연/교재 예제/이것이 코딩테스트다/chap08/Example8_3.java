package chap08;

import java.io.*;

public class Example8_3 {
    static long[] d = new long[101]; // 메모이제이션 배열

    static long fibo(int x) {
        System.out.printf("f(%d) ", x);

        if (x == 1 || x == 2)
            return 1;
        
        if (d[x] != 0)
            return d[x];

        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }

    public static void main(String[] args) throws IOException {
        fibo(6);
    }
}
