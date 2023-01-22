/*
 * @author Minyeong Park
 * @date 2022.12.18.
 * 시험 감독
 * 반례 참고 : https://www.acmicpc.net/board/view/72565, https://www.acmicpc.net/board/view/77764
 * 문제 링크 : https://www.acmicpc.net/problem/13458
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long[] students = new long[n];
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += 1;
            students[i] = students[i] - b;
            if (students[i] > 0) {
                if (students[i] % c == 0) {
                    count += students[i] / c;
                } else {
                    count += students[i] / c + 1;
                }
            }
        }

        System.out.println(count);
    }
}