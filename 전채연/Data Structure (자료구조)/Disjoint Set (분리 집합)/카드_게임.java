/*
    백준 16566번 : 카드 게임
    - 문제 유형 : 자료구조, 이분 탐색, 분리 집합
*/

import java.io.*;
import java.util.*;

public class 카드_게임 {
    static int N;
    static int[] parent;

    /** 부모 노드의 카드 번호 반환 */
    static public int findParent(int card) {
        if (parent[card] == card) return card;
        return parent[card] = findParent(parent[card]);
    }

    /** 낼 수 있는 최소 카드의 합집합 연산 */
    static public int union(int card) {
        int a = findParent(card + 1);
        if (a == N) return a;
        int b = findParent(a + 1);
        parent[a] = b;

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 카드의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 고르는 카드의 개수 M 입력
        int K = Integer.parseInt(st.nextToken()); // 카드를 내는 횟수 K 입력
        parent = new int[N + 1];

        for (int i = 1; i < N; i++) {
            parent[i] = i + 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken()); // 민수가 뽑은 카드의 번호 입력
            parent[num] = num;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int card = Integer.parseInt(st.nextToken()); // 철수가 낸 카드의 번호 입력
            bw.write(union(card) + "\n"); // 민수가 낼 카드의 번호 입력
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
