import java.io.*;

public class A_YESorYES {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            if (s.charAt(0) != 'y' && s.charAt(0) != 'Y') {
                System.out.println("NO");
                continue;
            }
            if (s.charAt(1) != 'e' && s.charAt(1) != 'E') {
                System.out.println("NO");
                continue;
            }
            if (s.charAt(2) != 's' && s.charAt(2) != 'S') {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
        }
    }
}