/*
 * @author Minyeong Park
 * @date 2022.05.22.
 * 숫자 카드
 * 참고 : https://steady-coding.tistory.com/40, https://minhamina.tistory.com/127
 * 문제 링크 : https://www.acmicpc.net/problem/10815
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] sg_num;
    static int[] test_num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        sg_num = new int[N];
        for (int i = 0; i < N; i++) {
            sg_num[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 테스트할 정수 개수
        st = new StringTokenizer(br.readLine());
        test_num = new int[M];
        for (int i = 0; i < M; i++) {
            test_num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sg_num);

        for (int i = 0; i < M; i++) {
            binarySearch(i);
        }
    }

    static void binarySearch(int i) {
        int low = 0;
        int high = sg_num.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (test_num[i] == sg_num[mid]) {
                System.out.print("1 ");
                return;
            } else if (test_num[i] > sg_num[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.print("0 ");
        return;
    }
}