package chap11;

import java.io.*;

public class Question11_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int count = 0;
        char c = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (c != S.charAt(i)) {
                count++;
                c = S.charAt(i);
            }
        }

        System.out.println((count + 1) / 2);
    }
}
