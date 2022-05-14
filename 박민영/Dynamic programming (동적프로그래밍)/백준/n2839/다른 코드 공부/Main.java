/*
 * @author Minyeong Park
 * @date 2022.02.27.
 * 설탕 배달 (더 효율적인 코드)
 * https://www.acmicpc.net/problem/2839
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 1. 수학적으로 3과 5를 빼면서 접근하기
//        int cnt = 0; //현재 수를 담는 변수
//
//        while(true) {
//            if (n % 5 == 0) {
//                bw.write(String.format("%d", n/5 + cnt));
//                break;
//            } else if (n < 0) {
//                bw.write(String.format("%d", -1));
//            }
//            n = n-3;
//            cnt++;
//        }


        // 2. 동적 프로그래밍 방법으로 조금 더 효율적이고 빠르게 구현하기

        if (n == 4 || n == 7) {
            bw.write(String.format("%d", -1));
        } else if (n % 5 == 0) {
            bw.write(String.format("%d", n / 5));
        } else if (n % 5 == 1 || n % 5 == 3) {
            bw.write(String.format("%d", n / 5 + 1));
        } else if (n % 5 == 2 || n % 5 == 4) {
            bw.write(String.format("%d", n / 5 + 2));
        }

        bw.flush();

    }
}