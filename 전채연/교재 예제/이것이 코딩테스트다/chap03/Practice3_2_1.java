package chap03;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Practice3_2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int size = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[size];
        s = br.readLine();
        st = new StringTokenizer(s);
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        
        int sum = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (count >= k) {
                sum += numbers[numbers.length - 2];
                count = 0;
                continue;
            }
            sum += numbers[numbers.length - 1];
            count++;
        }

        System.out.println(sum);
    }
}
