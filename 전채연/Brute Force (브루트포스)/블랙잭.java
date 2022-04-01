/*
    백준 2798번 : 블랙잭
    - 문제 유형 : 브루트포스 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;

public class 블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken()); // 카드의 개수 입력
        int M = Integer.parseInt(st.nextToken()); // 숫자 M 입력
        int[] cards = new int[N]; // 카드의 수 저장 배열

        s = br.readLine();
        st = new StringTokenizer(s);
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken()); // 카드의 수 입력
        }

        br.close();

        int answer = 0; // M 이하의 가장 가까운 카드의 수
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    // 세 카드의 합이 M보다 작거나 같고 answer보다 크면 갱신
                    if (sum <= M && answer < sum) {
                        answer = sum;
                    }
                }
            }
        }

        // 출력
        System.out.println(answer);
    }
}