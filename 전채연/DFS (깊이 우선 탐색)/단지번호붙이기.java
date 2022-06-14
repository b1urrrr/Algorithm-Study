import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기 {
    static int n;
    static int[][] graph;
    static List<Integer> houses = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 깊이 우선 탐색 메서드
    static int dfs(int x, int y, int sum) {
        graph[x][y] = 2; // 방문한 곳은 2로 표시하여 처리
        sum++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위를 벗어난 경우
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            // 집이 있는 곳이면 재귀적으로 깊이 우선 탐색 호출
            if (graph[nx][ny] == 1) sum = dfs(nx, ny, sum);
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 지도의 크기 N 입력
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) - '0'; // 집 존재 여부 입력
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 지도에 1이 표시된 곳이 있으면 깊이 우선 탐색 시작
                if (graph[i][j] == 1) 
                    houses.add(dfs(i, j, 0)); // 리스트에 단지에 속하는 집의 수 추가
            }
        }

        System.out.println(houses.size()); // 단지 수 출력
        // 집의 수에 대해 오름차순으로 정렬
        Collections.sort(houses);
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(houses.get(i)); // 오름차순으로 단지에 속하는 집의 수 출력
        }
    }
}
