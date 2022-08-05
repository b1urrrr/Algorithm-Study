/*
 * @author Minyeong Park
 * @date 2022.08.05.
 * 2007년
 * 문제 링크 : https://www.acmicpc.net/problem/1924
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int days_sum = d;
        switch (m) {
            case 12:
                days_sum += 30; // 11월 일수
            case 11:
                days_sum += 31; // 10월 일수
            case 10:
                days_sum += 30;
            case 9:
                days_sum += 31;
            case 8:
                days_sum += 31;
            case 7:
                days_sum += 30;
            case 6:
                days_sum += 31;
            case 5:
                days_sum += 30;
            case 4:
                days_sum += 31;
            case 3:
                days_sum += 28;
            case 2:
                days_sum += 31;
            case 1:
                break;
        }

        int remainder = days_sum % 7;
        switch (remainder) {
            case 0 :
                System.out.println("SUN");
                break;
            case 1 :
                System.out.println("MON");
                break;
            case 2 :
                System.out.println("TUE");
                break;
            case 3 :
                System.out.println("WED");
                break;
            case 4 :
                System.out.println("THU");
                break;
            case 5 :
                System.out.println("FRI");
                break;
            case 6 :
                System.out.println("SAT");
                break;
        }
    }
}