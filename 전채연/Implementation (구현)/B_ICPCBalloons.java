import java.io.*;

public class B_ICPCBalloons {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int balloons = 0;
            boolean[] solved = new boolean[26];
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                if (!solved[s.charAt(j) - 'A']) {
                    solved[s.charAt(j) - 'A'] = true;
                    balloons += 2;
                } else {
                    balloons++;
                }
            }

            System.out.println(balloons);
        }
    }
}