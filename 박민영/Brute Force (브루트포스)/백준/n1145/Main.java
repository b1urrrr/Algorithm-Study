/*
 * @author Minyeong Park
 * @date 2022.08.28.
 * 적어도 대부분의 배수
 * 원리 참고 : https://kosaf04pyh.tistory.com/124
 * 문제 링크 : https://www.acmicpc.net/problem/1145
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        int result = num[0]; // 가장 작은 수
        int temp = result;
        while (true) {
            int count = 0;
            if (temp % num[0] == 0) {
                count++;
            }
            if (temp % num[1] == 0) {
                count++;
            }
            if (temp % num[2] == 0) {
                count++;
            }
            if (temp % num[3] == 0) {
                count++;
            }
            if (temp % num[4] == 0) {
                count++;
            }

            if (count >= 3) {
                result = temp;
                break;
            } else {
                temp++;
            }
        }
        System.out.println(result);
    }
}