package chap11;

import java.io.*;

public class Question11_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        long result = Integer.parseInt(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            int b = Integer.parseInt(String.valueOf(s.charAt(i)));

            result = Math.max(result + b, result * b);
        }

        System.out.println(result);
    }
}
