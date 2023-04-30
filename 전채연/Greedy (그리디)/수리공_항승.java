/*
    백준 1449번 : 수리공 항승
    - 문제 유형 : 그리디 알고리즘, 정렬
*/

import java.io.*;
import java.util.*;

public class 수리공_항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수 N 입력
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이 L 입력
        int[] waterLeakSpots = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) waterLeakSpots[i] = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 위치 입력

        Arrays.sort(waterLeakSpots); // 물이 새는 곳의 위치 오름차순 정렬

        float startOfTape = waterLeakSpots[0] - 0.5f;
        float endOfTape = startOfTape + L;
        int count = 1;
        for (int i = 1; i < N; i++) {
            float spot = waterLeakSpots[i] + 0.5f;

            // 이전 테이프로 수리가 가능한 경우
            if (spot <= endOfTape) continue;

            // 이전 테이프로 수리가 불가능한 경우
            count++;
            startOfTape = Float.max(endOfTape, waterLeakSpots[i] - 0.5f);
            endOfTape = startOfTape + L;
        }

        // 항승이가 필요한 테이프의 개수 출력
        System.out.println(count);
    }
}