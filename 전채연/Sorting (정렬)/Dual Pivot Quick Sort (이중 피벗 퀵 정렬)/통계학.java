/*
    백준 2108번 : 통계학
    - 문제 유형 : 수학, 정렬
    - 풀이 유형 : Arrays.sort를 활용한 이중 피벗 퀵 정렬 (Dual Pivot Quick Sort)
*/

import java.io.*;
import java.util.Arrays;

public class 통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] data = new int[N]; // 입력값 배열
        int[] count = new int[8001]; // 카운팅 배열
        int sum = 0; // 합계

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine()); // 수 입력
            sum += data[i];
            count[data[i] + 4000]++;
        }
        double ave = Math.round((double) sum / N); // 산술평균

        Arrays.sort(data); // 정렬

        int med = data[(N - 1) / 2]; // 중앙값

        int max = 0; // 최빈값 중 최솟값
        int max2 = 8001; // 최빈값이 여러 개인 경우 2번째로 작은 값
        for (int i = 1; i <= 8000; i++) {
            if (count[max] < count[i]) {
                max = i;
                max2 = 8001;
            } else if (count[max] == count[i]) {
                if (max > i) {
                    max2 = max;
                    max = i;
                } else if (max2 > i) {
                    max2 = i;
                }
            }
        }
        int mode = (max2 < 8001) ? max2 : max;
        mode -= 4000;
        
        int range = data[N - 1] - data[0]; // 범위

        // 결과 출력
        System.out.println((int) ave);
        System.out.println(med);
        System.out.println(mode);
        System.out.println(range);
    }
}