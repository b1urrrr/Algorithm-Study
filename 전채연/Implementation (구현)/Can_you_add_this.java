import java.io.*;
import java.util.*;

public class Can_you_add_this {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            a += Integer.parseInt(st.nextToken());

            bw.write(a + "\n");
        }

        bw.flush();
    }
}
