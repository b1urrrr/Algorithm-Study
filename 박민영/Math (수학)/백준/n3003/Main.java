/*
 * @author Minyeong Park
 * @date 2022.12.11.
 * 킹, 퀸, 룩, 비숍, 나이트, 폰
 * 문제 링크 : https://www.acmicpc.net/problem/3003
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = {1,1,2,2,2,8};
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != answer[i]) {
                System.out.print((answer[i] - num) + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}