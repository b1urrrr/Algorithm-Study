/*
 * @author Minyeong Park
 * @date 2023.01.18.
 * 토너먼트 (내가 푼 것 - 그냥 문제 내용 그대로 진행해서.. 효율적인 코드는 아님...)
 * 문제 링크 : https://www.acmicpc.net/problem/1057
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int j_first = Integer.parseInt(st.nextToken());
        int h_first = Integer.parseInt(st.nextToken());

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }
        int j = j_first;
        int h = h_first;
        int round_cnt = 1;

        while (true) {
            if ((list.length / 2) % 2 == 0) { // 현재 라운드 참가자 수가 짝수인 경우
                for (int i = list.length / 2; i < list.length; i++) {
                    list[i] = -1;
                }
            } else { // 홀수인 경우
                for (int i = list.length / 2 + 1; i < list.length; i++) {
                    list[i] = -1;
                }
            }

            if ((h % 2 == 0 && j + 1 == h) || (j % 2 == 0 && h + 1 == j)) {
                break;
            }

            j = (j % 2 == 0) ? j / 2 : j / 2 + 1;
            h = (h % 2 == 0) ? h / 2 : h / 2 + 1;

            round_cnt++;

            if (list[1] == -1) {
                round_cnt = -1;
                break;
            }
        }

        System.out.println(round_cnt);
    }
}