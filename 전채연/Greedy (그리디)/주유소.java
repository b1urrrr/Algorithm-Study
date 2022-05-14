/*
    백준 13305번 : 주유소
    - 문제 유형 : 그리디 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수 입력
        BigInteger[] roads = new BigInteger[n - 1]; // 도로의 길이 저장 배열
        BigInteger[] costs = new BigInteger[n]; // 주유소의 기름 가격 저장 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            roads[i] = new BigInteger(st.nextToken()); // 도로의 길이 입력
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = new BigInteger(st.nextToken()); // 주유소의 기름 가격 입력
        }

        BigInteger result = new BigInteger("0");
        BigInteger min = new BigInteger("1000000001"); // 지금까지 만난 도시들의 기름 가격의 최솟값
        for (int i = 0; i < n - 1; i++) {
            if (min.compareTo(costs[i]) > 0) min = costs[i];
            // 최솟값 기름 가격과 다음 도로의 길이를 곱하고 결과값에 더함
            result = result.add(min.multiply(roads[i]));
        }

        // 결과 출력
        System.out.println(result);
    }
}
