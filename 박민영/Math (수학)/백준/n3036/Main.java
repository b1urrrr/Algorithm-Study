/*
 * @author Minyeong Park
 * @date 2022.07.08.
 * 링
 * 문제 링크 : https://www.acmicpc.net/problem/3036
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());
            int gcf = cal_gcf(a, b);
            System.out.println(a / gcf + "/" + b / gcf);
        }
    }

    static int cal_gcf(int a, int b) {
        int r = a % b;

        while (true) {
            a = b;
            b = r;
            if (b == 0) {
                break;
            }
            r = a % b;
        }
        return a;
    }
}