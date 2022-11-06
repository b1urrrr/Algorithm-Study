/*
 * @author Minyeong Park
 * @date 2022.11.06.
 * 2진수 8진수
 * 참고 : https://www.acmicpc.net/board/view/33919
 * 문제 링크 : https://www.acmicpc.net/problem/1373
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num2 = br.readLine();
        int cnt = 0;
        while (cnt < num2.length()) {
            cnt += 3;
        }

        int[] arr2 = new int[cnt];
        for (int i = num2.length() - 1, j = cnt - 1; i >= 0; i--, j--) {
            arr2[j] = num2.charAt(i) - '0';
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < arr2.length) {
            sb.append(arr2[index] * 4 + arr2[index+1] * 2 + arr2[index+2]);
            index += 3;
        }
        System.out.println(sb);
    }
}