/*
 * @author Minyeong Park
 * @date 2022.03.09.
 * 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            int temp_idx = i;  // 가장 작은 값이 있었던 인덱스 번호
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    temp_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[temp_idx] = temp;

        }

        for (int i = 0; i < num; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }
}