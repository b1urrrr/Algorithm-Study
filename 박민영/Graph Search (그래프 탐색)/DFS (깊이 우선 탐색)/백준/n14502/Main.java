/*
 * @author Minyeong Park
 * @date 2022.10.16.
 * 연구소
 * 코드 참고 : https://github.com/ndb796/python-for-coding-test/blob/master/13/2.java
 * 문제 링크 : https://www.acmicpc.net/problem/14502
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, result = 0;
    static int[][] map; // 초기 맵 배열
    static int[][] temp; // 벽을 설치한 뒤의 맵 배열

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    // dfs를 이용해 울타리를 설치하면서, 매 번 안전 영역의 크기 계산
    static void dfs(int count) {
        // 울타리가 3개 설치된 경우
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i,j);
                    }
                }
            }

            // 안전 영역의 최대값 계산
            result = Math.max(result, getScore());
            return;
        }

        // 빈 공간에 울타리를 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    count += 1;
                    dfs(count);
                    map[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    // dfs를 이용해 각 바이러스가 사방으로 퍼지도록 하기
    static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 상하좌우 중에서 바이러스가 퍼질 수 있는 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == 0) {
                    // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    // 현재 맵에서 안전 영역의 크기 계산하는 메서드
    static int getScore() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    score++;
                }
            }
        }
        return score;
    }
}