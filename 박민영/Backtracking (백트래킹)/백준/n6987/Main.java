/*
 * @author Minyeong Park
 * @date 2022.12.01.
 * 월드컵
 * 원리 및 코드 참고 : https://jaejin89.tistory.com/41
 * 문제 링크 : https://www.acmicpc.net/problem/6987
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] c1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] c2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5 ,4, 5, 5};
    static int[] win = new int[6];
    static int[] draw = new int[6];
    static int[] lose = new int[6];
    static boolean possible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int win_sum = 0;
            int draw_sum = 0;
            int lose_sum = 0;
            possible = false;

            for (int j = 0; j < 6; j++) {
                win[j] = Integer.parseInt(st.nextToken());
                win_sum += win[j];
                draw[j] = Integer.parseInt(st.nextToken());
                draw_sum += draw[j];
                lose[j] = Integer.parseInt(st.nextToken());
                lose_sum += lose[j];
            }

            // 승 무 패 합이 30이 되어야 함
            if (win_sum + draw_sum + lose_sum != 30) {
                possible = false;
            } else {
                solve(0);
            }
            if (possible) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }

    static void solve(int game) { // game : 몇 번째 게임인지
        if (possible) {
            return; // 가능한 경우이므로 나머지 다 리턴시킴
        }

        // 마지막 게임까지 왔다면 가능한 경우다.
        if (game == 15) {
            possible = true;
            return;
        }
        int t1 = c1[game]; // team 1
        int t2 = c2[game]; // team 2

        // team1의 승리가 가능하다면
        if (win[t1] > 0 && lose[t2] > 0) {
            win[t1]--;
            lose[t2]--;
            solve(game+1);
            win[t1]++;
            lose[t2]++;
        }

        // team2의 승리가 가능하다면
        if (lose[t1] > 0 && win[t2] > 0) {
            lose[t1]--;
            win[t2]--;
            solve(game+1);
            lose[t1]++;
            win[t2]++;
        }

        // team1, team2 무승부가 가능하다면
        if (draw[t1] > 0 && draw[t2] > 0) {
            draw[t1]--;
            draw[t2]--;
            solve(game+1);
            draw[t1]++;
            draw[t2]++;
        }
    }
}