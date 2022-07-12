package chap11;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Question11_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 동전의 개수 입력
        int[] coins = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken()); // 동전의 금액 입력
        }

        Arrays.sort(coins);

        int target = 1;
        for (int i = 0; i < N; i++) {
            if (target < coins[i]) break;
            target += coins[i]; // target부터 지금까지 합한 금액까지는 만들 수 있음
        }

        System.out.println(target);
    }    
}
