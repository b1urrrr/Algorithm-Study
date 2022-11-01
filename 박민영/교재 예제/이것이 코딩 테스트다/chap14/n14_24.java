// chap14 Q.24 안테나

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n14_24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] homes = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            homes[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(homes[0]);
            return;
        }

        Arrays.sort(homes);
        System.out.println(homes[(n-1)/2]);
    }
}