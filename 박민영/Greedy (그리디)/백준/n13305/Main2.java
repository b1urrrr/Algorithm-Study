/*
 * @author Minyeong Park
 * @date 2022.07.02.
 * 주유소 (다른 코드 공부)
 * 코드 출처 : https://st-lab.tistory.com/192
 * 문제 링크 : https://www.acmicpc.net/problem/13305
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[n];
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int[] city = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long minCost = city[1]; // 이전 까지의 과정 중 주유 최소 비용
        for (int i = 1; i < n; i++) {
            // 현재 주유소가 이전 주유소의 기름값보다 쌀 경우 minCost 갱신
            if (city[i] < minCost)
                minCost = city[i];

            sum += minCost * distance[i];
        }

        System.out.println(sum);
    }
}