/*
 * @author Minyeong Park
 * @date 2023.05.28.
 * 직사각형
 * 문제 링크 : https://www.acmicpc.net/problem/27323
 */


import java.io.*;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println(a * b);
    }
}