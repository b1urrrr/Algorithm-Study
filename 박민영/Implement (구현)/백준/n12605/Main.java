/*
 * @author Minyeong Park
 * @date 2022.03.06.
 * 단어 순서 뒤집기
 * https://www.acmicpc.net/problem/12605
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            bw.write("Case #" + (i + 1) + ": ");
            StringTokenizer st = new StringTokenizer(arr[i]);
            String[] stn = new String[st.countTokens()];;

            for (int j = 0; st.hasMoreTokens(); j++) {
                stn[j] = st.nextToken();
            }

            for (int j = stn.length - 1; j >= 0; j--) {
                bw.write(stn[j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
