/*
 * @author Minyeong Park
 * @date 2022.12.04.
 * 유레카 이론
 * 원리 및 코드 참고 : https://tweety1121.tistory.com/entry/%EB%B0%B1%EC%A4%80-10448%EB%B2%88-%EC%9C%A0%EB%A0%88%EC%B9%B4-%EC%9D%B4%EB%A1%A0-%EC%9E%90%EB%B0%94-%ED%92%80%EC%9D%B4
 * 문제 링크 : https://www.acmicpc.net/problem/10448
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] triangle = new int[45]; // n : 1 ~ 44까지 Tn이 1000 이하
        for (int i = 1; i < 45; i++) {
            triangle[i] = i * (i+1) / 2;
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            int result = eureka(k, triangle);
            System.out.println(result);
        }
    }

    static int eureka(int n, int[] triangle) {
        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    int sum = triangle[i] + triangle[j] + triangle[k];
                    if (sum == n) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}