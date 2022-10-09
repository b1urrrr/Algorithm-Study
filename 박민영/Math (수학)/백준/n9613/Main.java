/*
 * @author Minyeong Park
 * @date 2022.10.09.
 * GCD 합
 * 참고 : https://www.acmicpc.net/board/view/81519, https://blockdmask.tistory.com/53, https://www.acmicpc.net/board/view/19559
 * 문제 링크 : https://www.acmicpc.net/problem/9613
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    result += gcd(arr[j], arr[k]);
                }
            }
            System.out.println(result);
        }
    }

    static int gcd(int a, int b) {
        int left = -1;
        while (left != 0) {
            left = a % b;
            if (left != 0) {
                a = b;
                b = left;
            }
        }
        return b;
    }
}