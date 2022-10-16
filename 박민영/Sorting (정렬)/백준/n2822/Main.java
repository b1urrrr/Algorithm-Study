/*
 * @author Minyeong Park
 * @date 2022.10.16.
 * 점수 계산
 * 문제 링크 : https://www.acmicpc.net/problem/2822
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] scores = new int[8][2];
        for (int i = 0; i < 8; i++) {
            scores[i][0] = Integer.parseInt(br.readLine());
            scores[i][1] = i + 1;
        }

        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int sum = 0;
        int[] order = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += scores[i][0];
            order[i] = scores[i][1];
        }
        Arrays.sort(order);
        System.out.println(sum);
        for (int i : order) {
            System.out.print(i + " ");
        }
    }
}