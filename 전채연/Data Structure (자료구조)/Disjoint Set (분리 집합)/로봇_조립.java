/*
    백준 18116번 : 로봇 조립
    - 문제 유형 : 자료 구조, 분리 집합
*/

import java.io.*;
import java.util.*;

public class 로봇_조립 {
    static int MAX = (int) 1e6;
    static int N;
    static int[] parent, count;

    static int findParent(int robot) {
        if (parent[robot] == robot) return robot;
        return parent[robot] = findParent(parent[robot]);
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a == b) return;

        if (a < b) {
            parent[b] = a;
            count[a] += count[b];
        } else {
            parent[a] = b;
            count[b] += count[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        parent = new int[MAX + 1];
        count = new int[MAX + 1];

        Arrays.fill(count, 1);
        for (int i = 1; i <= MAX; i++) parent[i] = i;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String flag = st.nextToken();

            // 로봇의 부품을 알려주는 경우
            if (flag.equals("I")) {
                int a = Integer.parseInt(st.nextToken()); // 부품 a 입력
                int b = Integer.parseInt(st.nextToken()); // 부품 b 입력
                union(a, b);
                continue;
            }

            // 로봇의 부품의 개수를 물어보는 경우
            int c = Integer.parseInt(st.nextToken()); // 부품 c 입력
            bw.write(count[findParent(c)] + "\n"); // 지금까지 알아낸 해당 로봇의 부품 개수 출력
        }

        bw.flush();
    }
}
