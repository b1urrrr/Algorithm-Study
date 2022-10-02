/*
    백준 18428번 : 감시 피하기
    - 문제 유형 : 백트래킹, 브루트 포스
*/

import java.io.*;
import java.util.*;

public class 감시_피하기 {
    static int N;
    static boolean result = false;
    static String[][] hallway;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Location> teacher = new ArrayList<>();

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean voidable() {
        for (int i = 0; i < teacher.size(); i++) {
            int tx = teacher.get(i).x;
            int ty = teacher.get(i).y;

            // 네 방향 탐색
            for (int j = 0; j < 4; j++) {
                int nx = tx;
                int ny = ty;
                while (true) {
                    nx += dx[j];
                    ny += dy[j];

                    // 복도의 범위를 벗어난 경우 탐색 종료
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    // 장애물을 만난 경우 탐색 종료
                    if (hallway[nx][ny].equals("O")) break;
                    // 학생을 만난 경우 false 반환
                    if (hallway[nx][ny].equals("S")) return false;
                }
            }
        }

        return true;
    }

    static void backtracking(int x, int y, int depth) {
        // 피할 수 있는 방법을 찾은 경우 종료
        if (result == true) return;

        // 장애물 세 개를 설치한 경우 결과 갱신 및 백트래킹 종료
        if (depth == 3) {
            result = voidable();
            return ;
        }

        // 장애물 설치
        for (; x < N; x++) {
            for (; y < N; y++) {
                // 아무것도 존재하지 않는 칸이면 장애물 설치
                if (hallway[x][y].equals("X")) {
                    hallway[x][y] = "O";
                    backtracking(x, y + 1, depth + 1); // 재귀 호출
                    if (result == true) return;
                    hallway[x][y] = "X";
                }
            }
            y = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 복도의 크기 입력
        hallway = new String[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                hallway[i][j] = st.nextToken(); // 복도의 정보 입력
                if (hallway[i][j].equals("T")) teacher.add(new Location(i, j));
            }
        }

        // 백트래킹 시작
        backtracking(0, 0, 0);

        // 3개의 장애물을 설치하여 모든 학생들을 감시로부터 피하도록 할 수 있는지의 여부 출력
        if (result) System.out.println("YES");
        else System.out.println("NO");
    }
}