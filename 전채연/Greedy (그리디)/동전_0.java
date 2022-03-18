import java.io.*;
import java.util.StringTokenizer;

public class 동전_0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        int[] coins = new int[num];

        for (int i = num - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int count = 0;
        while (cost > 0) {
            for (int c : coins) {
                if (cost >= c) {
                    cost -= c;
                    count ++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
