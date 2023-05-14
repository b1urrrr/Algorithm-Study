import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt_0 = 0;
            int cnt_1 = 0;
            for (int j = 0; j < 4; j++) {
                if (check0(Integer.parseInt(st.nextToken()))) {
                    cnt_0++;
                } else {
                    cnt_1++;
                }
            }

            if (cnt_0 == 1 && cnt_1 == 3) {
                sb.append("A\n");
            } else if (cnt_0 == 2 && cnt_1 == 2) {
                sb.append("B\n");
            } else if (cnt_0 == 3 && cnt_1 == 1) {
                sb.append("C\n");
            } else if (cnt_0 == 4 && cnt_1 == 0) {
                sb.append("D\n");
            } else {
                sb.append("E\n");
            }
        }
        System.out.println(sb);
    }

    static boolean check0(int x) {
        if (x == 0) {
            return true;
        }
        return false;
    }
}