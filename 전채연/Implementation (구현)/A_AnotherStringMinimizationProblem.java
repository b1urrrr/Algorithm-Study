import java.io.*;
import java.util.StringTokenizer;

public class A_AnotherStringMinimizationProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // a의 길이
            int m = Integer.parseInt(st.nextToken()); // s의 길이
            int[] a = new int[n];
            char[] s = new char[m];
            
            for (int i = 0; i < m; i++) {
                s[i] = 'B';
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                int min = Math.min(a[i] - 1, m - a[i]);
                int max = Math.max(a[i] - 1, m - a[i]);

                // 앞 문자가 B인 경우
                if (s[min] == 'B') {
                    s[min] = 'A';
                }
                // 앞 문자가 A인 경우
                else {
                    s[max] = 'A';
                }
            }

            for (int i = 0; i < m; i++) {
                System.out.print(s[i]);
            }
            System.out.println();
        }
    }
}