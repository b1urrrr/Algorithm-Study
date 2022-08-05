/*
 * @author Minyeong Park
 * @date 2022.08.05.
 * 2007년 (다른 코드 공부)
 * 출처 : https://www.acmicpc.net/source/12382393
 * 문제 링크 : https://www.acmicpc.net/problem/1924
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dateArray = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int numOfDays = 0;

        for (int i = 0; i < m - 1; i++) {
            numOfDays += monthArray[i];
        }
        numOfDays += d;
        System.out.println(dateArray[numOfDays % 7]);
    }
}