/*
 * @author Minyeong Park
 * @date 2023.04.09.
 * 코딩은 체육과목 입니다
 * 문제 링크 : https://www.acmicpc.net/problem/25314
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i * 4 <= n; i++) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}