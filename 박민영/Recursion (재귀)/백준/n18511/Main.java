/*
 * @author Minyeong Park
 * @date 2022.11.18.
 * 큰 수 구성하기
 * 원리 및 코드 참고 : https://kistone.tistory.com/17
 * 문제 링크 : https://www.acmicpc.net/problem/18511
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] nums;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        recur(0);
        System.out.println(ans);
    }

    static void recur(int now) {
        if (now > n) return;

        if (ans < now) ans = now;

        for (int i = k - 1; i > -1; i--) {
            recur(now * 10 + nums[i]);
        }
    }
}