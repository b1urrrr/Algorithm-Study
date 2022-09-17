/*
 * @author Minyeong Park
 * @date 2022.09.17.
 * 로프
 * 원리 참고 : https://pangsblog.tistory.com/21
 * 문제 링크 : https://www.acmicpc.net/problem/2217
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] ropes = new Integer[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }
        Arrays.sort(ropes, Collections.reverseOrder());

        int count = 0;
        int max_weight = 0;
        for (int i = 0; i < n; i++) {
            ++count;
            int weight = ropes[i] * count;
            if (weight > max_weight) {
                max_weight = weight;
            }
        }
        System.out.println(max_weight);
    }
}