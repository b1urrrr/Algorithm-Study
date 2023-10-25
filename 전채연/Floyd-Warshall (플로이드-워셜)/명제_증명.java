/*
    백준 2224번 : 명제 증명
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 명제_증명 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 명제의 개수 N 입력
        int alphabetCnt = 'z' - 'A' + 1;
        boolean[][] graph = new boolean[alphabetCnt][alphabetCnt];
        boolean[][] visited = new boolean[alphabetCnt][alphabetCnt];

        for (int i = 0; i < alphabetCnt; i++) graph[i][i] = true;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int assumption = st.nextToken().charAt(0) - 'A';
            st.nextToken();
            int conclusion = st.nextToken().charAt(0) - 'A';
            graph[assumption][conclusion] = true;
        }

        int count = 0;
        for (int a = 0; a < alphabetCnt; a++) {
            for (int b = 0; b < alphabetCnt; b++) {
                for (int i = 0; i < alphabetCnt; i++) {
                    graph[a][b] = graph[a][b] || (graph[a][i] && graph[i][b]);
                    if (a == b || visited[a][b]) continue;
                    if (graph[a][b]) {
                        count++;
                        sb.append((char) (a + 'A') + " => " + (char) (b + 'A') + "\n");
                        visited[a][b] = true;
                    }
                }
            }
        }
        sb.insert(0, count + "\n");

        System.out.print(sb);
   } 
}
