/*
 * @author Minyeong Park
 * @date 2023.01.22.
 * 0 = not cute / 1 = cute
 * 문제 링크 : https://www.acmicpc.net/problem/10886
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cute = 0;
        int not_cute = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                cute++;
            } else {
                not_cute++;
            }
        }

        if (cute > not_cute) {
            System.out.println("Junhee is cute!");
        } else {
            System.out.println("Junhee is not cute!");
        }
    }
}