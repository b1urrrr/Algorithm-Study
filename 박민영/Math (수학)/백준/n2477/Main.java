/*
 * @author Minyeong Park
 * @date 2022.05.29.
 * 참외밭
 * 원리 및 코드 참고 : https://kau-algorithm.tistory.com/11
 * 문제 링크 : https://www.acmicpc.net/problem/2477
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] line = new int[6];
        int EW = 0; // 동서
        int NS = 0; // 남북
        int n;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            line[i] = Integer.parseInt(st.nextToken());
            if (n >= 3)
                NS += line[i];
            else
                EW += line[i];
        }

        NS /= 2; // 큰 직사각형의 위 아래 변의 길이
        EW /= 2; // 큰 직사각형의 왼쪽 오른쪽 변의 길이

        int index = -1;
        for (int i = 0; i < 6; i++) {
            if (line[i] == NS || line[i] == EW) {
                int j = i + 1;
                if (j > 5) j = 0; // 현재 index가 5, 즉 배열의 마지막이라면 다음 인덱스 j는 0이 되어야 함!
                if (line[j] == NS || line[j] == EW) { // 다음 인덱스 j도 잘리지 않은 변이라면!
                    index = j;
                    break;
                }
            }
        }

        int x = index + 2;
        int y = index + 3;
        if (x > 5) x -= 6;
        if (y > 5) y -= 6;
        System.out.println((NS * EW - line[x] * line[y]) * k);
    }
}