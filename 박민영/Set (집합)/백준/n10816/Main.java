/*
 * @author Minyeong Park
 * @date 2022.05.27.
 * 숫자 카드 2
 * Hashmap 풀이 참고 : https://www.acmicpc.net/board/view/90220
 * 문제 링크 : https://www.acmicpc.net/problem/10816
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드 개수

        // 1) HashMap을 이용하는 방법
//        HashMap<Integer, Integer> num_card = new HashMap<Integer,Integer>(); // 카드 숫자 : 개수
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            int temp_num = Integer.parseInt(st.nextToken());
//            num_card.put(temp_num, num_card.getOrDefault(temp_num, 0) + 1);
//        }
//
//        int m = Integer.parseInt(br.readLine()); // 테스트 개수
//        st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < m; i++) {
//            int test_num = Integer.parseInt(st.nextToken());
//            sb.append(num_card.getOrDefault(test_num, 0)).append(" ");
//        }
//        System.out.println(sb);

        // 2) 배열을 이용하는 방법
        int[] num_card = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp_num = Integer.parseInt(st.nextToken());
            num_card[temp_num + 10000000]++;
        }

        int m = Integer.parseInt(br.readLine()); // 테스트 개수
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int test_num = Integer.parseInt(st.nextToken());
            sb.append(num_card[test_num + 10000000]).append(" ");
        }
        System.out.println(sb);

    }
}