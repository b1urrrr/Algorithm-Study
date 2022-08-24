/*
 * @author Minyeong Park
 * @date 2022.08.03.
 * 랜선 자르기
 * 참고 및 출처 : https://st-lab.tistory.com/269
 * 문제 링크 : https://www.acmicpc.net/problem/1654
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int[] wires;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        long max = 0;
        wires = new int[k];
        for (int i = 0; i < k; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            if (max < wires[i])
                max = wires[i];
        }

        // 반드시 max에서 +1 값이어야 한다.
        max++;

        long min = 0; // 탐색 길이 최솟값
        long mid = 0;

        while (min < max) {
            // 범위 내에서 중간 길이를 구한다.
            mid = (max + min) / 2;

            long count = 0;

            // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.
            for (int i = 0; i < wires.length; i++) {
                count += (wires[i] / mid);
            }

            // [Upper Bound 형식] : 찾고자 하는 특정 값을 초과하는 '첫 위치'를 반환.
            // mid 길이로 잘랐을 때의 개수가, 만들고자 하는 랜선의 개수보다 작다면
            // 자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
            // 그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.

            if (count < n)
                max = mid;
            else
                min = mid + 1;
        }
        // UpperBound로 얻어진 값(min)에 -1 이 최대 길이가 된다.
        System.out.println(min - 1);
    }
}