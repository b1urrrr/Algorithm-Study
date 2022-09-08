/*
    백준 11780번 : 플로이드 2
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 플로이드_2 {
    static final int INF = (int) 1e9;
    static int[][] spt; // 최단 거리 테이블
    static ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>(); // 최단 경로 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수 n 입력
        int m = Integer.parseInt(br.readLine()); // 버스의 개수 m 입력
        spt = new int[n + 1][n + 1];
        
        // 최단 경로 그래프 무한으로 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(spt[i], INF);
        }

        // 시작 도시와 도착 도시가 동일한 경우 최단 경로 0으로 초기화, 최단 경로 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                if (i == j) spt[i][j] = 0;
                graph.get(i).add(new ArrayList<>());
            }
        }

        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 버스의 시작 도시 a 입력
            int b = Integer.parseInt(st.nextToken()); // 버스의 도착 도시 b 입력
            int c = Integer.parseInt(st.nextToken()); // 한 번 타는 데 필요한 비용 c 입력
            if (c < spt[a][b]) {
                spt[a][b] = c;
                // 최단 경로 초기화
                graph.get(a).get(b).clear();
                graph.get(a).get(b).add(a);
                graph.get(a).get(b).add(b);
            }
        }

        // 플로이드-워셜 알고리즘 실행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (spt[a][i] + spt[i][b] < spt[a][b]) {
                        spt[a][b] = spt[a][i] + spt[i][b];
                        // 최단 경로 초기화
                        graph.get(a).get(b).clear();
                        for (int x = 0; x < graph.get(a).get(i).size(); x++) {
                            graph.get(a).get(b).add(graph.get(a).get(i).get(x));
                        }
                        for (int x = 1; x < graph.get(i).get(b).size(); x++) {
                            graph.get(a).get(b).add(graph.get(i).get(b).get(x));
                        }
                    }
                }
            }
        }

        // 도시 i에서 j로 가는데 필요한 최소 비용 출력 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 이동 가능한 버스가 존재하지 않는 경우 0 출력
                if (spt[i][j] == INF) System.out.print("0 ");
                else {
                    System.out.print(spt[i][j] + " ");
                }
            }
            System.out.println();
        }

        // 도시 i에서 도시 j로 가는 최단 경로 정보 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 최소 비용에 포함되어 있는 도시의 개수 k 출력
                System.out.print(graph.get(i).get(j).size() + " ");
                // 최단 경로 출력
                for (int x = 0; x < graph.get(i).get(j).size(); x++) {
                    System.out.print(graph.get(i).get(j).get(x) + " ");
                }
                System.out.println();
            }
        }
    }
}