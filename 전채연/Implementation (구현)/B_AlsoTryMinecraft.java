import java.io.*;
import java.util.StringTokenizer;

public class B_AlsoTryMinecraft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 맵 길이
        int m = Integer.parseInt(st.nextToken()); // 퀘스트 개수

        st = new StringTokenizer(br.readLine());
        int[] world = new int[n];
        for (int i = 0; i < n; i++) {
            world[i] = Integer.parseInt(st.nextToken());
        }

        long[] right = new long[n];
        for (int i = 1; i < n; i++) {
            if (world[i - 1] > world[i]) right[i] = right[i - 1] + world[i - 1] - world[i];
            else right[i] = right[i - 1];
        }

        long[] left = new long[n];
        for (int i = n - 2; i >= 0; i--) {
            if (world[i + 1] > world[i]) left[i] = left[i + 1] + world[i + 1] - world[i];
            else left[i] = left[i + 1];
        }

        for (int quest = 0; quest < m; quest++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작점
            int t = Integer.parseInt(st.nextToken()); // 도착점

            // 오른쪽으로 이동
            if (s <= t) System.out.println(right[t - 1] - right[s - 1]);
            // 왼쪽으로 이동
            else System.out.println(left[t - 1] - left[s - 1]);
        }
    }    
}
