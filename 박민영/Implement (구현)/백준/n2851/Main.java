/*
 * @author Minyeong Park
 * @date 2022.08.13.
 * 슈퍼 마리오
 * 문제 링크 : https://www.acmicpc.net/problem/2851
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int now = Integer.parseInt(br.readLine());
            if (sum + now > 100) {
                if (Math.abs(sum - 100) < Math.abs(sum + now - 100)) {
                    break;
                } else {
                    sum += now;
                    break;
                }
            }
            sum += now;
        }
        System.out.println(sum);
    }
}