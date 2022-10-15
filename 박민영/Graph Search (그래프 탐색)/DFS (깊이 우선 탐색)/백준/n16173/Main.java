/*
 * @author Minyeong Park
 * @date 2022.10.16.
 * 점프왕 쩰리 (Small)
 * 참고 : https://www.acmicpc.net/board/view/95957
 * 문제 링크 : https://www.acmicpc.net/problem/16173
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        if (result) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static void dfs(int x, int y) {
        if (x >= n || y >= n) {
            return;
        }
        if (map[x][y] == -1) {
            result = true;
            return;
        } else {
            if (map[x][y] > 0 && map[x][y] < n) {
                dfs(x+map[x][y], y); // x,y 에서 오른쪽으로 가볼 때
                dfs(x, y+map[x][y]); // x,y 에서 아래쪽으로 가볼 때
            }
        }
    }
}