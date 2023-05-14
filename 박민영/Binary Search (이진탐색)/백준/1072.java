/*
 * @author Minyeong Park
 * @date 2023.05.14.
 * 게임
 * 참고 : https://zoomkoding.github.io/%EB%B0%B1%EC%A4%80/2019/09/30/baekjoon-1072.html, https://girawhale.tistory.com/116, https://sio2whocode.tistory.com/60?category=924371
 * 문제 링크 : https://www.acmicpc.net/problem/1072
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = y * 100 / x; // 100 곱해줄 때 범위 초과가 일어나므로 다 long 형으로 선언

        // 형택이가 게임을 더 하는 횟수를 탐색 1 ~ 1000000000 까지
        int left = 1;
        int right = 1000000000; // 주어진 x의 최대값이 10억일 때 승률 1퍼를 올리기 위해서는 10억판이 필요하므로, left = 1, right는 10억으로 설정함
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            long nz = (y + mid) * 100 / (x + mid);

            if (z < nz) { // 왼쪽 부분을 탐색해야 함
                result = mid; // 원하는 승률을 찍는 판수의 최솟값을 찾는 것이므로, 왼쪽 부분으로 변경할 때 result값 업데이트
                right = mid - 1;
            } else {
                left = mid + 1; // 오른쪽 부분을 탐색해야 함
            }
        }

        System.out.println(result);
    }
}