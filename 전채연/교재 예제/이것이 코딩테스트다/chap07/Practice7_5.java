package chap07;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Practice7_5 {
    static void binary_search(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (target == array[mid]) {
                System.out.print("yes ");
                return;
            } else if (target < array[mid]) end = mid - 1;
            else start = mid + 1;
        }
        System.out.print("no ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 가게의 부품 개수 입력
        int[] dongbin = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dongbin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dongbin);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            binary_search(dongbin, Integer.parseInt(st.nextToken()), 0, dongbin.length - 1);
        }
    }    
}
