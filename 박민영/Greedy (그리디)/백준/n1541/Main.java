/*
 * @author Minyeong Park
 * @date 2022.06.29.
 * 잃어버린 괄호
 * 원리 참고 : https://st-lab.tistory.com/148, https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rain483&logNo=220723525725
 * 문제 링크 : https://www.acmicpc.net/problem/1541
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split("-");
        int[] sum_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String[] temp_arr = arr[i].split("\\+");
            for (int j = 0; j < temp_arr.length; j++) {
                sum_arr[i] += Integer.parseInt(temp_arr[j]);
            }
        }

        int result = sum_arr[0];
        for (int i = 1; i < sum_arr.length; i++) {
            result -= sum_arr[i];
        }
        System.out.println(result);
    }
}