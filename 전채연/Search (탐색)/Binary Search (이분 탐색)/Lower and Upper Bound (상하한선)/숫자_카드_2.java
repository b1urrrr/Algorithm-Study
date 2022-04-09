/*
    백준 10816번 : 숫자 카드 2
    - 문제 유형 : 자료 구조, 정렬, 이분 탐색
    - 풀이 유형 : 상하한선 알고리즘 (Lower and Upper Bound Algorithm)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 숫자_카드_2 {
    // 하한선 : 크거나 같은 첫 번째 원소의 인덱스 반환 (없으면 end 반환)
    static int lower_bound(int[] data, int num) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            // num보다 크거나 같으면 뒷부분을 탐색 범위에서 제거
            if (data[mid] >= num) {
                end = mid;
            } else { // num보다 작으면 앞부분과 mid를 탐색 범위에서 제거
                start = mid + 1;
            }
        }
        return end;
    }

    // 상한선 : 더 큰 첫 번째 원소의 인덱스 반환 (없으면 end 반환)
    static int upper_bound(int[] data, int num) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            // num보다 작거나 같으면 앞부분과 mid를 탐색 범위에서 제거
            if (data[mid] <= num) {
                start = mid + 1;
            } else { // num보다 크면 뒷부분을 탐색 범위에서 제거
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 상근이의 숫자 카드의 개수
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken()); // 숫자 카드의 정수 입력
        }

        // 카드 정렬
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine()); // 정수의 개수
        s = br.readLine();
        st = new StringTokenizer(s);

        int[] data = new int[M];
        for (int i = 0; i < M; i++) {
            data[i] = Integer.parseInt(st.nextToken()); // 정수 입력
            bw.write(upper_bound(cards, data[i]) - lower_bound(cards, data[i]) + " "); // 숫자 카드의 개수 출력
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}
