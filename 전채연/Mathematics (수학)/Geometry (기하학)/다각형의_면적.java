/*
    백준 2166번 : 다각형의 면적
    - 문제 유형 : 기하학, 다각형의 넓이
    - 풀이 유형 : 신발끈 공식
*/

import java.io.*;
import java.util.*;

public class 다각형의_면적 {
    static class Location {
        long x;
        long y;

        public Location(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 점의 개수 N 입력
        Location[] locations = new Location[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken()); // 점의 x 좌표 입력
            long y = Integer.parseInt(st.nextToken()); // 점의 y 좌표 입력
            locations[i] = new Location(x, y);
        }

        // 신발끈 공식 수행
        long sum1 = locations[N - 1].x * locations[0].y;
        long sum2 = locations[0].x * locations[N - 1].y;
        for (int i = 0; i < N - 1; i++) {
            sum1 += (locations[i].x * locations[i + 1].y);
            sum2 += (locations[i].y * locations[i + 1].x);
        }
        double result = Math.abs(sum1 - sum2) / 2.0;

        // 면적 반올림하여 첫째 자리까지 출력
        System.out.printf("%.1f\n", result);
    }
}
