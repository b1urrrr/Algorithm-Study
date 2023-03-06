/*
 * @author Minyeong Park
 * @date 2023.03.05.
 * 수들의 합 5 (다른 풀이 공부)
 * 원리 참고 : https://www.inflearn.com/course/lecture?courseSlug=%EB%91%90%EC%9E%87-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94&unitId=148341
 * 문제 링크 : https://www.acmicpc.net/problem/2018
 */



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start_idx = 1;
        int end_idx = 1;
        int count = 1;
        int sum = 1;

        while (end_idx != n) {
            if (sum < n) {
                end_idx++;
                sum = sum + end_idx;
            } else if (sum > n) {
                sum = sum - start_idx; // 기존에 있었던 것을 빼주고
                start_idx++;           // 인덱스를 증가
            } else { // 같은 경우
                count++;
                end_idx++;
                sum = sum + end_idx;
            }
        }

        System.out.println(count);
    }
}