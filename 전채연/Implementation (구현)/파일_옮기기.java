import java.io.*;
import java.util.StringTokenizer;

public class 파일_옮기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int apple1 = Integer.parseInt(st.nextToken());
        int orange1 = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s);
        int apple2 = Integer.parseInt(st.nextToken());
        int orange2 = Integer.parseInt(st.nextToken());

        int min = Math.min(apple2 + orange1, apple1 + orange2);
        System.out.println(min);
    }
}