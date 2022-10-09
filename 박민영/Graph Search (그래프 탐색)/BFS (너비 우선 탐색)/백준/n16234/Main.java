/*
 * @author Minyeong Park
 * @date 2022.10.09.
 * 인구 이동
 * 참고 : https://github.com/ndb796/python-for-coding-test/blob/master/13/7.java
 * 문제 링크 : https://www.acmicpc.net/problem/16234
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    static int n, l, r;
    static int totalCount = 0;

    static int[][] graph = new int[50][50];
    static int[][] unions = new int[50][50];
                    // 좌 하 우  상
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 특정 위치에서 출발하여 모든 연하블 체크한 뒤에 데이터 갱신
    static void process(int x, int y, int index) {
        // (x,y)의 위치와 연결된 나라 (연합) 정보를 담는 리스트
        ArrayList<Position> united = new ArrayList<>();
        united.add(new Position(x, y));

        // BFS를 위한 큐 사용
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x,y));
        unions[x][y] = index;      // 현재 연합의 번호 할당
        int summary = graph[x][y]; // 현재 연합의 전체 인구 수
        int count = 1;             // 현재 연합의 국가 수

        while (!q.isEmpty()) {
            Position pos = q.poll();
            x = pos.getX();
            y = pos.getY();
            // 현재 위치에서 4가지 방향을 확인하며
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 바로 옆에 있는 나라를 확인
                if (0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
                    // 옆에 있는 나라와 인구 차이가 L <= x <= R 라면
                    int gap = Math.abs(graph[nx][ny] - graph[x][y]);

                    if  (l <= gap && gap <= r) {
                        q.offer(new Position(nx, ny));
                        // 연합에 추가하기
                        unions[nx][ny] = index;
                        summary += graph[nx][ny];
                        count += 1;
                        united.add(new Position(nx, ny));
                    }
                }
            }
        }

        // 연합 국가끼리 인구를 분배
        for (int i = 0; i < united.size(); i++) {
            x = united.get(i).getX();
            y = united.get(i).getY();
            graph[x][y] = summary / count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 더이상 인구 이동을 할 수 없을 때까지 반복
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    unions[i][j] = -1;
                }
            }

            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (unions[i][j] == -1) { // 해당 나라가 아직 처리되지 않았다면
                        process(i, j, index);
                        index += 1;
                    }
                }
            }

            // 모든 인구 이동이 끝난 경우
            if (index == n * n) break;
            totalCount += 1;
        }

        System.out.println(totalCount);
    }
}