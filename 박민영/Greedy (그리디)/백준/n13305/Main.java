/*
 * @author Minyeong Park
 * @date 2022.07.02.
 * 주유소
 * 참고(반례) : https://www.acmicpc.net/board/view/79399, https://www.acmicpc.net/board/view/87104, https://www.acmicpc.net/board/view/85716
 * 문제 링크 : https://www.acmicpc.net/problem/13305
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[n];
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int[] city = new int[n+1];
        int min_city_idx = n-1;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n-1; i++) {
            if (city[i] < city[min_city_idx])
                min_city_idx = i;
        }

        long oil_sum = 0;
        int end = n;
        while (min_city_idx >= 1) {
            long temp_distance_sum = 0;
            for (int i = min_city_idx; i < end; i++) {
                temp_distance_sum += distance[i];
            }
            oil_sum += city[min_city_idx] * temp_distance_sum;
            end = min_city_idx;
            min_city_idx = min_city_idx - 1;
            for (int i = 1; i < end; i++) {
                if (city[i] < city[min_city_idx])
                    min_city_idx = i;
            }
        }

        System.out.println(oil_sum);
    }
}