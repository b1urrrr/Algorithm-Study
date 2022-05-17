package chap04;

import java.io.*;

public class Example4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i <= time; i++) {
            for (int j = 0; j < 60; j++) {
                for (int t = 0; t < 60; t++) {
                    if (i % 10 == 3 || j % 10 == 3 || t % 10 == 3 || j / 10 == 3 || t / 10 == 3) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
