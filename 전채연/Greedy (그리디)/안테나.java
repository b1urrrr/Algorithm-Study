/*
    백준 18310번 : 안테나
    - 문제 유형 : 그리디 알고리즘, 정렬
*/

import java.io.*;
import java.util.*;

public class 안테나 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 집의 수 N 입력
        int[] houses = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken()); // 집의 위치 입력
        }

        // 정렬
        Arrays.sort(houses);

        // 안테나를 설치할 위치의 값을 출력
        System.out.println(houses[(N - 1) / 2]);
    }
}
