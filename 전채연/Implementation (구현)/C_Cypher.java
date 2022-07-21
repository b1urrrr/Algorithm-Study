import java.io.*;
import java.util.StringTokenizer;

public class C_Cypher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 바퀴의 개수 n
            int[] results = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                results[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int roll = Integer.parseInt(st.nextToken());
                String pattern = st.nextToken();

                for (int r = 0; r < roll; r++) {
                    switch(pattern.charAt(r)) {
                        case 'U':
                            if (results[j] == 0) results[j] = 9;
                            else results[j]--;
                            break;
                        case 'D':
                            if (results[j] == 9) results[j] = 0;
                            else results[j]++;
                            break;
                        default:
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                System.out.print(results[j] + " ");
            }
            System.out.println();
        }
    }
}
