/*
 * @author Minyeong Park
 * @date 2022.03.26.
 * 좌표 정렬하기
 * 참고한 글 : https://st-lab.tistory.com/110
 * 문제 링크 : https://www.acmicpc.net/problem/11650
 */


import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {   // 첫 번째 원소가 같다면 두 번째 원소끼리 비교
                    return o1[1] - o2[1];   // 양수 리턴 : o1가 더 큼, 음수 리턴 : o1가 더 작음, 0 리턴 : 둘이 같음
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
    }
}