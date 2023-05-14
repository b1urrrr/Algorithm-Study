/*
 * @author Minyeong Park
 * @date 2023.05.07.
 * 문자와 문자열
 * 문제 링크 : https://www.acmicpc.net/problem/27866
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        System.out.println(s.charAt(n-1));
    }
}