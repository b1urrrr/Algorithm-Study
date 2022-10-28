/*
    백준 14501번 : 퇴사
    - 문제 유형 : 동적 계획법
*/

import java.io.*;
import java.util.*;

public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 퇴사까지 남은 N일 입력
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); // 상담을 완료하는 데 걸리는 시간 T 입력
            int P = Integer.parseInt(st.nextToken()); // 상담 시 받을 수 있는 금액 P 입력
            P += cost[i - 1];
            
            if (i + T - 1 <= N) cost[i + T - 1] = Math.max(P, cost[i + T - 1]);
            cost[i] = Math.max(cost[i - 1], cost[i]);
        }

        // 백준이가 얻을 수 있는 최대 이익 출력
        System.out.println(cost[N]);
    }
}