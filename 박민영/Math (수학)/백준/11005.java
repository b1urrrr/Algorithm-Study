/*
 * @author Minyeong Park
 * @date 2023.05.21.
 * 진법 변환 2
 * 문제 링크 : https://www.acmicpc.net/problem/11005
 */


import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(Integer.toString(n, b).toUpperCase(Locale.ROOT));
    }
}