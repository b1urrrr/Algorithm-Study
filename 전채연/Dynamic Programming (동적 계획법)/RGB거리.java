/*
    백준 1149번 : RGB거리
    - 문제 유형 : 동적 계획법
*/

import java.io.*;
import java.util.*;

public class RGB거리 {
    static class Cost {
        int red;
        int green;
        int blue;

        public Cost(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public int getMinCost() {
            return Math.min(red, Math.min(green, blue));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 집의 수 N 입력

        Cost result = new Cost(0, 0, 0);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken()); // 빨강으로 칠하는 비용 입력
            int green = Integer.parseInt(st.nextToken()); // 초록으로 칠하는 비용 입력
            int blue = Integer.parseInt(st.nextToken()); // 파랑으로 칠하는 비용 입력

            int redCost = Math.min(result.green + green, result.blue + blue);
            int greenCost = Math.min(result.red + red, result.blue + blue);
            int blueCost = Math.min(result.red + red, result.green + green);

            result = new Cost(redCost, greenCost, blueCost);
        }

        // 모든 집을 칠하는 비용의 최솟값 출력
        System.out.println(result.getMinCost());
    }
}
