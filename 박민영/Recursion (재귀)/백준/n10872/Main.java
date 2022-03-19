/*
 * @author Minyeong Park
 * @date 2022.03.17.
 * 팩토리얼
 * https://www.acmicpc.net/problem/10872
 */


import java.io.*;

public class Main {
    static int recur(int n) {
        if (n <= 1)
            return 1;
        else {
            return n * recur(n - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.format("%d",recur(n)));
        bw.flush();
    }
}