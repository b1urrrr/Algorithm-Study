/*
    백준 10867번 : 중복 빼고 정렬하기
    - 문제 유형 : 정렬
    - 풀이 유형 : 카운팅 정렬 (Counting Sort)
*/

import java.io.*;
import java.util.StringTokenizer;

public class 중복_빼고_정렬하기 {
    static int SIZE = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 수의 개수 입력
        int[] positive = new int[SIZE]; // 양의 정수를 저장하는 배열
        int[] negative = new int[SIZE]; // 음의 정수를 저장하는 배열

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        
        // N개의 수 입력하여 입력한 값의 인덱스를 가지는 배열 값 증가
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) positive[num]++;
            else negative[-num]++;
        }

        // 음의 정수 출력
        for (int i = SIZE - 1; i > 0; i--) {
            if (negative[i] == 0) continue;
            bw.write(-i + " ");
        }

        // 양의 정수 출력
        for (int i = 0; i < SIZE; i++) {
            if (positive[i] == 0) continue;
            bw.write(i + " ");
        }
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
