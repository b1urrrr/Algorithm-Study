package chap11;

import java.io.*;
import java.util.StringTokenizer;

public class Question11_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
            sum += coins[i];
        }
    }    
}
