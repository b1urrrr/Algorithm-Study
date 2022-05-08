import java.io.*;

public class IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sLen = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String p = "";
        for (int i = 0; i < n + n + 1; i++) {
            if (i % 2 == 0) {
                p = p.concat("I");
            } else {
                p = p.concat("O");
            }
        }

        int count = 0;
        for (int i = 0; i < sLen; i++) {
            int sCursor = i;
            int pCursor = 0;
            while (sCursor < sLen && pCursor < n + n + 1 && s.charAt(sCursor) == p.charAt(pCursor)) {
                sCursor++;
                pCursor++;
            }

            if (pCursor == n + n + 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
