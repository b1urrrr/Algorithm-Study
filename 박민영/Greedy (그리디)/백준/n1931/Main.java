/*
 * @author Minyeong Park
 * @date 2022.05.18.
 * 회의실 배정
 * 참고 : https://seeminglyjs.tistory.com/164(2차원 배열 정렬),
 *       https://st-lab.tistory.com/145 (무엇을 기준으로 정렬하는 게 좋은지 원리 파악)
 * 문제 링크 : https://www.acmicpc.net/problem/1931
 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] meeting = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시각을 기준으로 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) // 종료시간이 같을 경우 시작 시간이 빠른 순으로 정렬
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        int[] last_meeting = new int[2]; // 이전 회의 시간을 담는 임시 배열
        int count = 1;                   // 최종 회의 개수

        last_meeting[0] = meeting[0][0]; // 가장 빨리 끝나는 0번째 회의로 초기화함
        last_meeting[1] = meeting[0][1];

        for (int i = 1; i < N; i++) {
            if (last_meeting[1] <= meeting[i][0]) {
                count++;
                last_meeting[0] = meeting[i][0];
                last_meeting[1] = meeting[i][1];
            }
        }
        System.out.println(count);
    }
}