/*
 * @author Minyeong Park
 * @date 2022.03.24.
 * 소트인사이드
 * https://www.acmicpc.net/problem/1427
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int[] num_arr = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            num_arr[i] = Integer.parseInt(input.charAt(i) + "");
        }

        for (int i = 0; i < num_arr.length - 1; i++) {
            for (int j = num_arr.length - 1; j > i; j--) {
                if (num_arr[j-1] < num_arr[j]) {
                    int temp = num_arr[j-1];
                    num_arr[j-1] = num_arr[j];
                    num_arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < num_arr.length; i++) {
            bw.write(num_arr[i] + "");
        }
        bw.flush();
    }
}