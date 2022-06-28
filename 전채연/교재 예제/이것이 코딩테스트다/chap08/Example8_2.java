package chap08;

import java.io.*;

public class Example8_2 {
    static long[] d = new long[101]; // 메모이제이션 배열

    static long fibo(int x) {
        if (x == 1 || x == 2)
            return 1;
        
        if (d[x] != 0)
            return d[x];

        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(fibo(50));
    }
}
