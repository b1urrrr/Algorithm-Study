/*
 * @author Minyeong Park
 * @date 2022.03.11. & 12.
 * 수 정렬하기 3
 * https://www.acmicpc.net/problem/10989
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];    // 처음 배열
        int[] result = new int[num]; // 최종 결과 배열
        for (int i = 0; i < num; i++) {                 // arr 배열에 입력 받기
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] counting = new int[10001];
        for (int i = 0; i < num; i++) {                 // counting 배열에 입력 받기
            counting[arr[i]]++;
        }

        for (int i = 1; i < 10001; i++) {
            counting[i] += counting[i-1];               // 현재 counting 배열에 있는 값과 그 앞 인덱스의 값을 더함
        }

        for (int i = num-1; i >= 0; i--) {
            result[counting[arr[i]]-1] = arr[i];
            counting[arr[i]]--;
        }

        for (int i = 0; i < num; i++)
            bw.write(result[i] + "\n");

        bw.flush();
        bw.close();
    }

}