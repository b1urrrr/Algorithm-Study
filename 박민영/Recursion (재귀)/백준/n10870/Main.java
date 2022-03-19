/*
 * @author Minyeong Park
 * @date 2022.03.17.
 * 피보나치 수 5
 * https://www.acmicpc.net/problem/10870
 */


import java.io.*;

public class Main {
    static int fibo(int n) {
       if (n == 0) return 0;
       else if (n == 1) return 1;
       else return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        bw.write(String.format("%d",fibo(num)));
        bw.flush();
    }
}