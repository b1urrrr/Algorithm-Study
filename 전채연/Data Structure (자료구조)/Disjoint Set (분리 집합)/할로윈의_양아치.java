/*
    백준 20303번 : 할로윈의 양아치
    - 문제 유형 : 다이나믹 프로그래밍, 자료 구조, 그래프 이론, 그래프 구조, 분리 집합, 배낭 문제
*/

import java.io.*;
import java.util.*;

public class 할로윈의_양아치 {
    static int K;
    static int[] parent;
    static int[] candy;
    static int[] friendCnt;

    /** 루트 노드 탐색 후 반환 */
    private static int findParent(int child) {
        if (parent[child] == child) return child;
        return parent[child] = findParent(parent[child]);
    }

    /** 합집합 연산 */
    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a == b) return;

        if (a < b) {
            unionChild(a, b);
        } else {
            unionChild(b, a);
        }
    }

    /** 합집합 시 루트 노드 및 사탕 및 친구 개수 처리 */
    private static void unionChild(int small, int big) {
        parent[big] = small;
        candy[small] += candy[big];
        friendCnt[small] += friendCnt[big];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 거리에 있는 아이들의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 아이들의 친구 관계 수 M 입력
        K = Integer.parseInt(st.nextToken()); // 울음소리가 공명하기 위한 최소 아이의 수 K 입력
        parent = new int[N + 1];
        candy = new int[N + 1];
        friendCnt = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            candy[i] = Integer.parseInt(st.nextToken()); // i번 아이의 사탕의 수 ci 입력
            friendCnt[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 친구 a 입력
            int b = Integer.parseInt(st.nextToken()); // 친구 b 입력
            union(a, b);
        }
        
        int[] dp = new int[K];
        // candy[i]를 뺏는 경우
        for (int i = 1; i <= N; i++) {
            if (parent[i] != i) continue;
            for (int j = K - 1; j >= friendCnt[i]; j--) {
                // 뺏는 경우와 뺏지 않는 경우 중 최대값 저장
                dp[j] = Integer.max(dp[j], dp[j - friendCnt[i]] + candy[i]);
            }
        }

        // 스브러스가 어른들에게 들키지 않고 아이들로부터 뺏을 수 있는 최대 사탕의 수 출력
        System.out.println(dp[K - 1]);
    }
}
