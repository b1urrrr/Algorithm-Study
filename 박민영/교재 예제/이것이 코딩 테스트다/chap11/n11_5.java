// chap11 Q5. 볼링공 고르기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n11_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] balls = new int[n];
        int[] counts = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
            counts[balls[i]]++;
        }

        int result = 0;
        for (int i = 1; i < m; i++) {
            for (int j = i+1; j < m+1; j++) {
                result += counts[i] * counts[j];
            }
        }
        System.out.println(result);
    }
}
