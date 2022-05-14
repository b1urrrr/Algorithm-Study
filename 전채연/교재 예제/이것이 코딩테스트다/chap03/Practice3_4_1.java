package chap03;

import java.io.*;
import java.util.StringTokenizer;

public class Practice3_4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        while (n > 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n--;
            }
            count++;
        }

        System.out.println(count);
    }
}
