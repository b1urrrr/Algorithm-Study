/*
 * @author Minyeong Park
 * @date 2022.03.12.
 * 수 정렬하기 3 (다른 분의 코드를 공부함 - 출처 : https://st-lab.tistory.com/107)
 * https://www.acmicpc.net/problem/10989
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[10001]; // 카운팅 수를 담는 배열

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            // 해당 인덱스의 값을 1 증가
            cnt[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            // i값이 개수가 0이 될 때까지 출력 (빈도수를 의미)
            while (cnt[i] > 0) {
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);

    }

}