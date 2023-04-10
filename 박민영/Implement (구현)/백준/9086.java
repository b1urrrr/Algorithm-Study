/*
 * @author Minyeong Park
 * @date 2023.04.09.
 * 문자열
 * 문제 링크 : https://www.acmicpc.net/problem/9086
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)  + "\n");
        }
        System.out.println(sb);
    }
}