/*
 * @author Minyeong Park
 * @date 2022.09.10.
 * 나무 자르기
 * 원리 및 코드 참고 : https://github.com/b1urrrr/Algorithm-Study/blob/main/%EB%B0%95%EB%AF%BC%EC%98%81/%EA%B5%90%EC%9E%AC%20%EC%98%88%EC%A0%9C/%EC%9D%B4%EA%B2%83%EC%9D%B4%20%EC%BD%94%EB%94%A9%20%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4/chap07/n7_3.java,
 *                  https://www.acmicpc.net/board/view/76956,
 *                  https://www.acmicpc.net/board/view/24313,
 *                  https://st-lab.tistory.com/270
 * 문제 링크 : https://www.acmicpc.net/problem/2805
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] trees;
    static long remain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        long max_length = 0;
        long min_length = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max_length) {
                max_length = trees[i];
            }
        }
        while (min_length < max_length) {
            long mid = (max_length + min_length) / 2;
            remain = 0;
            for (int i = 0; i < n; i++) {
                remain += (trees[i] - mid >= 0) ? trees[i] - mid : 0;
            }

            if (remain < m) {
                max_length = mid;
            } else {
                min_length = mid + 1;
            }
        }

        System.out.println(min_length - 1);
    }
}