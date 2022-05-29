import java.io.*;
import java.util.StringTokenizer;

public class 치킨댄스를_추는_곰곰이를_본_임스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chicken = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coke = Integer.parseInt(st.nextToken());
        int beer = Integer.parseInt(st.nextToken());

        int total = coke / 2 + beer;
        System.out.println(Math.min(chicken, total));
    }
}
