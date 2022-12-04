package chap15;

import java.io.*;
import java.util.*;

public class Question15_28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 크기 N 입력

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 수열의 원소값이 인덱스와 동일한 고정점을 발견한 경우
            if (i == Integer.parseInt(st.nextToken())) {
                System.out.println(i);
                return;
            }
        }

        // 고정점이 없다면 -1 출력
        System.out.println(-1);
    }
}
