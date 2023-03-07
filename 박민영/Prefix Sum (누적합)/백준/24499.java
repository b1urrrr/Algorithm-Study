/*
 * @author Minyeong Park
 * @date 2023.03.08.
 * blobyum
 * 원리 및 코드 참고 : https://burningfalls.github.io/algorithm/boj-24499/
 * 문제 링크 : https://www.acmicpc.net/problem/24499
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] taste = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            taste[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = k-1;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += taste[i];
        }


        int max = sum;
        while (true) {
            sum -= taste[left];
            left = (left + 1) % n;
            right = (right + 1) % n;
            sum += taste[right];

            if (left == 0)
                break;

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}