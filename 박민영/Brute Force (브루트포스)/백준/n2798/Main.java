/*
 * @author Minyeong Park
 * @date 2022.03.26.
 * 블랙잭
 * https://www.acmicpc.net/problem/2798
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max_sum = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (arr[i]+arr[j]+arr[k] > max_sum && arr[i]+arr[j]+arr[k] <= M)
                        max_sum = arr[i]+arr[j]+arr[k];
                }
            }
        }

        bw.write(max_sum + "");
        bw.flush();
    }
}