/*
 * @author Minyeong Park
 * @date 2022.03.13.
 * 통계학
 * https://www.acmicpc.net/problem/2108
 */


import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. 산술평균
        bw.write(Math.round((float) Arrays.stream(arr).sum() / N) + "\n");

        // 2. 중앙값
        int[] counting = new int[8001];   // 범위 : -4000 ~ 4000
        int[] counting_2 = new int[8001]; // [3. 최빈값]에서 이용할 배열
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            counting[arr[i]+4000]++;
            counting_2[arr[i]+4000]++;    // [3. 최빈값]에서 이용할 것임
        }
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            result[counting[arr[i]+4000]-1] = arr[i];
            counting[arr[i]+4000]--;
        }

        bw.write( result[arr.length/2] + "\n");


        // 3. 최빈값
        int max_count = 0;     // 최빈값의 개수
        int max_num_idx = 0;   // 처음 나온 최빈값의 인덱스
        for (int i = 0; i < counting_2.length; i++) {  // 가장 많은 개수 찾기
            if (counting_2[i] > max_count) {
                max_count = counting_2[i];
                max_num_idx = i;
            }
        }
        for (int i = 0; i < counting_2.length; i++) {
            if (counting_2[i] == max_count && max_num_idx != i) { // 최빈값이 여러개가 있는 경우
                bw.write(i - 4000 + "\n");       // 두번째로 작은 값을 출력
                break;
            }
            if (i == counting_2.length - 1)   // 마지막까지 갔는데도 최빈값이 여러개가 아닌 경우
                bw.write(max_num_idx - 4000 + "\n");
        }

        // 4. 범위
        int max = -4001;
        int min = 4001;
        for (int i : arr) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        bw.write((max - min) + "\n");
        bw.flush();
    }
}