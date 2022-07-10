import java.io.*;

public class A_RoundDownThePrice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());

            if (m < 10) {
                System.out.println(m - 1);
                continue;
            }

            int power = 1;
            while (true) {
                int num = (int) Math.pow(10, power);
                // System.out.println(m + " : " + num);
                if (m >= num && m < num * 10) {
                    System.out.println(m - num);
                    break;
                }
                power++;
            }
        }
    }
}
