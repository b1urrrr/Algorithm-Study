/*
 * @author Minyeong Park
 * @date 2023.10.15.
 * 상근날드
 * 문제 링크 : https://www.acmicpc.net/problem/5543
 */



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b1 = Integer.parseInt(br.readLine());
        int b2 = Integer.parseInt(br.readLine());
        int b3 = Integer.parseInt(br.readLine());
        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        System.out.println(Math.min(b1,Math.min(b2,b3)) + Math.min(d1, d2) - 50);
    }
}