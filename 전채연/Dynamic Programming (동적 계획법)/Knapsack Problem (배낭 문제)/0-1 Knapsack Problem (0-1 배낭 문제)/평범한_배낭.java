/*
    백준 12865번 : 평범한 배낭
    - 문제 유형 : 다이나믹 프로그래밍, 배낭 문제, 0-1 배낭 문제
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class 평범한_배낭 {
    static class Bag{
        int weight;
        int value;

        Bag(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수 입력
        int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게 입력

        List<Bag> bags = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 물건의 무게 입력
            int V = Integer.parseInt(st.nextToken()); // 물건의 가치 입력
            bags.add(new Bag(W, V));
        }

        int[] dp = new int[K + 1]; // DP 테이블 (짐을 쪼갤 수 없는 0/1 Knapsack Problem은 DP로 풀이)

        // bags.get(i)를 넣는 경우
        for (int i = 0; i < N; i++) {
            // 넣을 수 있을 때까지 배낭 최대 무게가 j인 경우 계산
            for (int j = K; j >= bags.get(i).weight; j--) {
                // 넣은 경우와 넣지 않은 경우 중 최대값 저장
                dp[j] = Math.max(dp[j], dp[j - bags.get(i).weight] + bags.get(i).value);
            }
        }

        // 배낭에 넣을 수 있는 물건들의 가치합의 최댓값 출력
        System.out.println(dp[K]);
    }
}
