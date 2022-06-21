package chap07;

import java.io.*;
import java.util.StringTokenizer;

public class Practice7_6 {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[MAX + 1];
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());        
        for (int i = 0; i < n; i++) {
            numbers[Integer.parseInt(st.nextToken())]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (numbers[Integer.parseInt(st.nextToken())] > 0) System.out.print("yes ");
            else System.out.print("no ");
        }
    }    
}
