package chap08;

import java.io.*;

public class Example8_1 {
    static int fibo(int x) {
        if (x == 1 || x == 2) 
            return 1;
        
        return fibo(x - 1) + fibo(x - 2);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(fibo(4));
    }
}
