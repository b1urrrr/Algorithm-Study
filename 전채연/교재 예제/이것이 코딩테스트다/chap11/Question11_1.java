package chap11;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Question11_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 모험가의 수 N 입력
        int[] travelers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            travelers[i] = Integer.parseInt(st.nextToken()); // 모험가의 공포도 값 입력
        }

        // 공포도 기준으로 모험가 오름차순 정렬
        Arrays.sort(travelers);

        int result = 0; // 여행을 떠날 수 있는 그룹의 수
        int count = 0; // 현재 그룹의 인원
        int max = -1; // 현재 그룹 모험가들의 최대값 공포도

        for (int i = 0; i < N; i++) {
            max = Math.max(travelers[i], max);
            count++;

            // 그룹 결성 가능한 인원이 모였다면 result 증가
            if (max == count) {
                result++;
                count = 0; // 현재 그룹 인원 초기화
            }
        }

        // 여행을 떠날 수 있는 그룹 수의 최댓값 출력
        System.out.println(result);
    }
}