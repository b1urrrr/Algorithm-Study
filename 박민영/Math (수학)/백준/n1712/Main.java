/*
 * @author Minyeong Park
 * @date 2022.04.17.
 * 손익분기점
 * 문제 링크 : https://www.acmicpc.net/problem/1712
 */

import java.io.*;
import java.util.StringTokenizer;

// 처음에 작성한 코드 (시간 초과)
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        long a = Long.parseLong(st.nextToken());
//        long b = Long.parseLong(st.nextToken());
//        long c = Long.parseLong(st.nextToken());
//
//        int count = 0;
//        while (a + b * count >= c * count) {
//            count++;
//        }
//
//        if (count <= 0) { // 손익분기점이 없는 경우
//            System.out.println(-1);
//            return;
//        }
//
//        System.out.println(count);
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        if (b >= c)
            System.out.println(-1);
        else
            System.out.println(a / (c - b) + 1);
    }
}