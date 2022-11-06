import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        br.close();

        int gcd = gcd(x, y);
        System.out.println(gcd);
        System.out.println(x * y / gcd);
    }
}
