/*
 * @author Minyeong Park
 * @date 2022.04.20. & 22.
 * 좌표 압축
 * 풀이 참고 : https://st-lab.tistory.com/279
 * 문제 링크 : https://www.acmicpc.net/problem/18870
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] sort = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sort[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sort);

        HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>(); // 랭크를 매길 HashMap

        // 정렬된 배열을 순회하면서 map에 넣어준다
        int rank = 0;
        for (int v : sort) {
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++; // map에 넣고나면 다음 순위를 가리킬 수 있도록 1을 더함
            }
        }

        // 원본 배열을 차례대로 순회하면서 해당 원소에 대한 rank를 가져온다
        for (int key : arr) {
            bw.write(rankingMap.get(key) + " "); // 원본 배열 원소에 대한 value(rank)를 가져온다
        }
        bw.flush();
    }
}
