package chap14;

import java.io.*;
import java.util.*;

public class Question14_26 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 카드 묶음의 개수 N 입력
        int[] cards = new int[N];

        for (int i = 0 ; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine()); // 카드 묶음의 크기 입력
        }

        if (N == 1) {
            System.out.println(cards[0]);
            return ;
        }

        Arrays.sort(cards);

        int result = cards[0] + cards[1];

        for (int i = 2; i < N; i++) {
            result += result + cards[i];
        }

        System.out.println(result);
    }
}
