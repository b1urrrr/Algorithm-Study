/*
 * @author Minyeong Park
 * @date 2023.10.22.
 * 세 막대
 * 문제 링크 : https://www.acmicpc.net/problem/14215
\ */



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        if (arr[2] >= arr[0] + arr[1]) {
            arr[2] = arr[0] + arr[1] - 1;
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}