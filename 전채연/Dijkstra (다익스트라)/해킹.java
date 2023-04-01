/*
    백준 10282번 : 해킹
    - 문제 유형 : 그래프 이론, 데이크스트라
*/

import java.io.*;
import java.util.*;

public class 해킹 {
    static final int INF = (int) 1e9;
    static ArrayList<ArrayList<Computer>> graph;
    static int[] spt;
    static int n;

    static class Computer implements Comparable<Computer> {
        int index;
        int sec;

        Computer(int index, int sec) {
            this.index = index;
            this.sec = sec;
        }

        @Override
        public int compareTo(Computer other) {
            return this.sec - other.sec;
        }
    }

    /** 감염되는 컴퓨터 탐색 후 총 감염되는 컴퓨터 수 반환 */
    static int dijkstra(int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.add(new Computer(start, 0));
        spt[start] = 0;
        int infected = 1;

        while (!pq.isEmpty()) {
            Computer next = pq.remove();

            // 이미 처리한 컴퓨터인 경우
            if (spt[next.index] < next.sec) continue;

            for (int i = 0; i < graph.get(next.index).size(); i++) {
                int cost = next.sec + graph.get(next.index).get(i).sec;
                if (cost < spt[graph.get(next.index).get(i).index]) {
                    if (spt[graph.get(next.index).get(i).index] == INF) infected++;
                    spt[graph.get(next.index).get(i).index] = cost;
                    pq.add(new Computer(graph.get(next.index).get(i).index, cost));
                }
            }
        }

        return infected;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 t 입력

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수 n 입력
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수 d 입력
            int c = Integer.parseInt(st.nextToken()); // 해킹 당한 컴퓨터의 번호 c 입력
            
            graph = new ArrayList<>();
            spt = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                spt[i] = INF;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 컴퓨터 번호 a 입력
                int b = Integer.parseInt(st.nextToken()); // 컴퓨터 번호 b 입력
                int s = Integer.parseInt(st.nextToken()); // 감염까지 걸리는 시간 s 입력
                graph.get(b).add(new Computer(a, s));
            }

            int infected = dijkstra(c);

            // 마지막 컴퓨터가 감염되기까지 걸리는 시간 탐색
            int max = -1;
            for (int i = 1; i <= n; i++) {
                if (spt[i] == INF) continue;
                max = Math.max(max, spt[i]);
            }

            // 총 감염되는 컴퓨터 수와 마지막 컴퓨터가 감염되기까지 걸리는 시간 출력
            bw.write(infected + " " + max + "\n");
        }

        bw.flush();
    }
}
