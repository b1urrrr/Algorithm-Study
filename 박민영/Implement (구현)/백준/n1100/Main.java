/*
 * @author Minyeong Park
 * @date 2022.12.18.
 * 하얀 칸
 * 문제 링크 : https://www.acmicpc.net/problem/1100
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (line.charAt(j) == 'F' && ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}