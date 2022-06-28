package chap08;

import java.io.*;

public class Example8_4 {
    public static void main(String[] args) throws IOException {
        long[] d = new long[101];

        d[1] = 1;
        d[2] = 1;
        int n = 50;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[n]);
    }
}
