/*
 * @author Minyeong Park
 * @date 2022.03.09.
 * 단어 뒤집기
 * https://www.acmicpc.net/problem/9093
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String snt = br.readLine();
            StringTokenizer st = new StringTokenizer(snt);

            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                for (int j = word.length() - 1; j >= 0; j--) {
                    bw.write(word.charAt(j));
                }
                bw.write(" ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}