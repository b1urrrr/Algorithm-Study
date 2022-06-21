package chap07;

import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Practice7_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (set.contains(Integer.parseInt(st.nextToken())))
                System.out.print("yes ");
            else System.out.print("no ");
        }
    }
}
