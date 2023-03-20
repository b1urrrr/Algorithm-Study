/*
 * @author Minyeong Park
 * @date 2023.03.19.
 * 토마토
 * 놓친 부분 참고 : https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-7576%EB%B2%88-%ED%86%A0%EB%A7%88%ED%86%A0-Java-%EC%9E%90%EB%B0%94
 * 문제 링크 : https://www.acmicpc.net/problem/7576
 */



import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        ArrayList<Tomato> start = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    start.add(new Tomato(i, j));
                }
            }
        }

        Queue<Tomato> q = new LinkedList<>();
        for (int i = 0; i < start.size(); i++) {
            q.offer(start.get(i));
        }
        while (!q.isEmpty()) {
            Tomato now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (map[nx][ny] == 0) {
                        q.offer(new Tomato(nx, ny));
                        map[nx][ny] = map[now.x][now.y] + 1;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        System.out.println(result - 1);
    }
}

class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}