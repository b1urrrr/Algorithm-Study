/*
    백준 17404번 : RGB거리 2
    - 문제 유형 : 동적 계획법
*/

import java.io.*;
import java.util.*;

public class RGB거리_2 {
    static final int INF = (int) 1e9;

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

        Cost result[] = new Cost[3]; // 첫집 0: 빨강 선택, 1: 초록 선택, 2: 파랑 선택

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstRed = Integer.parseInt(st.nextToken()); // 처음 집을 빨강으로 칠하는 비용 입력
        int firstGreen = Integer.parseInt(st.nextToken()); // 처음 집을 초록으로 칠하는 비용 입력
        int firstBlue = Integer.parseInt(st.nextToken()); // 처음 집을 파랑으로 칠하는 비용 입력

        result[0] = new Cost(INF, firstRed, firstRed);
        result[1] = new Cost(firstGreen, INF, firstGreen);
        result[2] = new Cost(firstBlue, firstBlue, INF);

        for (int i = 1; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken()); // 빨강으로 칠하는 비용 입력
            int green = Integer.parseInt(st.nextToken()); // 초록으로 칠하는 비용 입력
            int blue = Integer.parseInt(st.nextToken()); // 파랑으로 칠하는 비용 입력

            for (int j = 0; j < 3; j++) {
                int redCost = Math.min(result[j].green + green, result[j].blue + blue);
                int greenCost = Math.min(result[j].red + red, result[j].blue + blue);
                int blueCost = Math.min(result[j].red + red, result[j].green + green);

                result[j] = new Cost(redCost, greenCost, blueCost);
            }
        }

        st = new StringTokenizer(br.readLine());
        int finalRed = Integer.parseInt(st.nextToken()); // 마지막 집을 빨강으로 칠하는 비용 입력
        int finalGreen = Integer.parseInt(st.nextToken()); // 마지막 집을 초록으로 칠하는 비용 입력
        int finalBlue = Integer.parseInt(st.nextToken()); // 마지막 집을 파랑으로 칠하는 비용 입력

        for (int j = 0; j < 3; j++) {
            int temp = 0;
            switch (j) {
                case 0:
                    temp = finalRed;
                    finalRed = INF;
                    break;
                case 1:
                    temp = finalGreen;
                    finalGreen = INF;
                    break;
                default:
                    temp = finalBlue;
                    finalBlue = INF;
            }

            int redCost = Math.min(result[j].green + finalGreen, result[j].blue + finalBlue);
            int greenCost = Math.min(result[j].red + finalRed, result[j].blue + finalBlue);
            int blueCost = Math.min(result[j].red + finalRed, result[j].green + finalGreen);

            result[j] = new Cost(redCost, greenCost, blueCost);

            switch (j) {
                case 0:
                    finalRed = temp;
                    break;
                case 1:
                    finalGreen = temp;
                    break;
                default:
                    finalBlue = temp;
            }
        }

        // 모든 집을 칠하는 비용의 최솟값 출력
        int min = Math.min(result[0].getMinCost(), Math.min(result[1].getMinCost(), result[2].getMinCost()));
        System.out.println(min);
    }
}
