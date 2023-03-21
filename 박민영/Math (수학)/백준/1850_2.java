/*
 * @author Minyeong Park
 * @date 2023.03.22.
 * 최대공약수 (다른 풀이)
 * 코드 참고 : https://pangsblog.tistory.com/61
 * 문제 링크 : https://www.acmicpc.net/problem/1850
 */



import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long rst = Euclid(a, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rst; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    static long Euclid(long a, long b) {
        while (b > 0) { // 유클리드 호제법 더 간단하게 쓰신 코드
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}