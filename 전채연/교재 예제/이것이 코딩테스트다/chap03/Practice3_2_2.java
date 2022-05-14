package chap03;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Practice3_2_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int size = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s);
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int first = numbers[size - 1];
        int second = numbers[size - 2];

        int count = m / (k + 1) * k;
        count += m % (k + 1);

        int result = count * first;
        result += (m - count) * second;

        System.out.println(result);
    }
}
