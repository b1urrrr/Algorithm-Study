/*
 * @author Minyeong Park
 * @date 2023.05.21.
 * 진법 변환
 * 문제 링크 : https://www.acmicpc.net/problem/2745
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        System.out.println(Integer.parseInt(n, b));
    }
}