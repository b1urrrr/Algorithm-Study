import java.io.*;
import java.util.StringTokenizer;

public class 타일_채우기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        Long n = Long.parseLong(st.nextToken());
        Long m = Long.parseLong(st.nextToken());

        System.out.println(n * m / 2);
    }
}