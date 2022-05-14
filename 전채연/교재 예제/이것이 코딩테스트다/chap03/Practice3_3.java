package chap03;

import java.io.*;
import java.util.StringTokenizer;

public class Practice3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int min = 10001;
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < m; j++) {
                min = Math.min(min, Integer.parseInt(st.nextToken()));
            }
            max = Math.max(min, max);
        }

        System.out.println(max);
    }
}
