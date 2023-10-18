/*
 * @author Minyeong Park
 * @date 2023.10.15.
 * 평균 점수
 * 문제 링크 : https://www.acmicpc.net/problem/10039
 */



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.max(Integer.parseInt(br.readLine()), 40);
        }
        System.out.println(sum / 5);
    }
}