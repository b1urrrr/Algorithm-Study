/*
 * @author Minyeong Park
 * @date 2023.02.19.
 * 컵홀더
 * 문제 링크 : https://www.acmicpc.net/problem/2810
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int cnt = 1;
        int idx = 0;
        while (idx < n) {
            if (line.charAt(idx) == 'S') {
                cnt++;
                idx++;
            } else {
                cnt++;
                idx += 2;
            }
        }
        System.out.println(Math.min(cnt, n));
    }
}