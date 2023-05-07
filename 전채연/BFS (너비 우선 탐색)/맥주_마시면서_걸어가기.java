/*
    백준 9205번 : 맥주 마시면서 걸어가기
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 맥주_마시면서_걸어가기 {
    static Coordinate[] places;
    static boolean[] visited;
    static int n;

    static enum Type {
        Home, Store, Festival
    }

    static class Coordinate {
        int index;
        int x;
        int y;
        Type type;

        public Coordinate(int index, int x, int y, Type type) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public int distanceFrom(Coordinate other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }

    static String bfs() {
        Queue<Coordinate> que = new LinkedList<>();
        que.add(places[0]);
        visited[0] = true;

        while (!que.isEmpty()) {
            Coordinate next = que.remove();
            // 페스티벌에 도착 가능한 경우
            if (next.distanceFrom(places[n + 1]) <= 1000) return "happy\n";

            for (int i = 1; i <= n; i++) {
                // 편의점에 도착 불가능한 경우
                if (next.distanceFrom(places[i]) > 1000) continue;
                // 이미 방문한 편의점인 경우
                if (visited[i]) continue;

                visited[i] = true;
                que.add(places[i]);
            }
        }

        return "sad\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 t 입력

        for (int t = 0; t < testCase; t++) {
            n = Integer.parseInt(br.readLine()); // 편의점의 개수 n 입력
            places = new Coordinate[n + 2];
            visited = new boolean[n + 2];

            // 집 정보 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            places[0] = new Coordinate(0, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Type.Home);
            
            // 편의점 정보 입력
            for (int s = 1; s <= n; s++) {
                st = new StringTokenizer(br.readLine());
                places[s] = new Coordinate(1 + s, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Type.Store);
            }

            // 락 페스티벌 정보 입력
            st = new StringTokenizer(br.readLine());
            places[n + 1] = new Coordinate(n + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Type.Festival);

            bw.write(bfs());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
