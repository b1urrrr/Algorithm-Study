import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class n16_35 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ugly = new int[1000]; // 못생긴 수를 담기 위한 테이블 (1차원 DP 테이블)

        // 2배, 3배, 5배를 위한 인덱스
        int i2 = 0, i3 = 0, i5 = 0;
        // 처음에 곱셈 값을 초기화
        int next2 = 2, next3 = 3, next5 = 5;

        ugly[0] = 1; // 첫 번재 못생긴 수는 1

        // 1부터 n까지의 못생긴 수들을 찾기
        for (int k = 1; k < n; k++) {
            // 가능한 곱셈 결과 중에서 가장 작은 수를 선택
            ugly[k] = Math.min(next2, Math.min(next3, next5));
//            // 작동 원리 헷갈리면 주석 풀고 보기
//            System.out.println(next2 + " " + next3 + " " + next5 + " >> " + ugly[k]);

            // 인덱스에 따라서 곱셈 결과를 증가
            if (ugly[k] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if (ugly[k] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if (ugly[k] == next5) {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }
        }

        System.out.println(ugly[n-1]);
    }
}
