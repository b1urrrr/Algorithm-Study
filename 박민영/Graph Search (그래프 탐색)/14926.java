/*
 * @author Minyeong Park
 * @date 2023.03.23.
 * Not Equal
 * 모르겠어서.. 원리 및 코드 참고 : https://jaimemin.tistory.com/512
 * 문제 링크 : https://www.acmicpc.net/problem/14926
 */



import java.io.*;

public class Main {
    static int MAX = 501;
    static int n;
    static int[][] crossed = new int[MAX][MAX]; // 간선 지나갔는지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int curVertex = 0; // 현재 정점

        crossed[1][n] = crossed[n][1] = 1; // 마지막 간선은 항상 마지막 정점에서 1번 정점으로 가는 선
        StringBuilder sb = new StringBuilder();

        // 1 ~ n까지 모든 정점을 지나는 간선 : (n * (n - 1) / 2)개
        for (int i = 0; i < (n * (n - 1) / 2); i++) {
            // 모든 정점을 훑어봄
            for (int vertex = 1; vertex <= n; vertex++) {
                // 정점이 자기 자신이거나 이미 지난 간선일 경우
                if (vertex == curVertex || crossed[curVertex][vertex] != 0)
                    continue;

                // 간선을 지나갔다고 표시해야 함
                crossed[curVertex][vertex] = crossed[vertex][curVertex] = 1;
                curVertex = vertex;
                break;
            }
            sb.append("a").append(curVertex).append(" ");
        }
        // 마지막 간선은 마지막 정점에서 a1이다.
        sb.append("a1");
        System.out.println(sb);
    }
}