/*
    백준 1043번 : 거짓말
    - 문제 유형 : 자료구조, 그래프 이론, 그래프 탐색, 분리 집합
*/

import java.io.*;
import java.util.*;

public class 거짓말 {
    static int[] parent;
    static boolean[] truth;

    /** 부모 파티 번호 반환 */
    static int findParent(int party) {
        if (parent[party] == party) return party;
        return parent[party] = findParent(parent[party]);
    }

    /** 합집합 연산 수행 */
    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b)  parent[b] = a;
        else parent[a] = b;
        truth[a] = truth[b] = truth[a] || truth[b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 파티의 수 M 입력
        parent = new int[M + 1];
        truth = new boolean[M + 1];
        int[] eariestParty = new int[N + 1];
        boolean[] doesKnowTheTruth = new boolean[N + 1];

        // 부모 테이블 초기화
        for (int i = 1; i <= M; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truePerson = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수 입력
        for (int i = 0; i < truePerson; i++) {
            doesKnowTheTruth[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int attendees = Integer.parseInt(st.nextToken()); // 파티에 오는 사람의 수 입력

            for (int j = 0; j < attendees; j++) {
                int p = Integer.parseInt(st.nextToken()); // 파티에 오는 사람 번호 입력
                if (doesKnowTheTruth[p]) truth[i] = truth[findParent(i)] = true;
                if (eariestParty[p] == 0) eariestParty[p] = i;
                else union(eariestParty[p], i);
            }
        }

        int result = 0;
        for (int i = 1; i <= M; i++) {
            if (!truth[findParent(i)]) result++;
        }

        // 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값 출력
        System.out.println(result);
    }
}
