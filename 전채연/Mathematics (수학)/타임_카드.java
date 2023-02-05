import java.io.*;
import java.util.StringTokenizer;

public class 타임_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int sec1 = Integer.parseInt(st.nextToken()) * 3600;
            sec1 += Integer.parseInt(st.nextToken()) * 60;
            sec1 += Integer.parseInt(st.nextToken());

            int sec2 = Integer.parseInt(st.nextToken()) * 3600;
            sec2 += Integer.parseInt(st.nextToken()) * 60;
            sec2 += Integer.parseInt(st.nextToken());

            int sec = sec2 - sec1;
            int hr = sec / 3600;
            sec %= 3600;
            int min = sec / 60;
            sec %= 60;

            System.out.printf("%d %d %d\n", hr, min, sec);
        }
    }
}