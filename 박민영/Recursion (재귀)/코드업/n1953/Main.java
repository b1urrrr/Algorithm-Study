/*
 * @author Minyeong Park
 * @date 2022.11.27.
 * (재귀함수) 삼각형 출력하기 1
 * 원리 및 코드 참고 : https://chucoding.tistory.com/14
 * 문제 링크 : https://codeup.kr/problem.php?id=1953
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        triangle(n, 0, 1);
    }
    static void triangle(int n, int start, int end) {
        if (start == n) return;
        else {
            if (start == end) {
                start = 0;
                end += 1;
                System.out.println();
            }
            System.out.print("*");
            triangle(n, start + 1, end);
        }
    }
}