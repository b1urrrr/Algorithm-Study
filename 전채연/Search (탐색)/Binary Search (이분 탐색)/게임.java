/*
    백준 1072번 : 수 찾기
    - 문제 유형 : 수학, 이분 탐색
*/

import java.io.*;
import java.util.*;

public class 게임 {
    static final int MAX_GAME_COUNT = (int) 1e9;
    static int X, Y, Z;

    /** 승률 반환 */
    static int getWinRate(int x, int y) {
        return (int) ((long) y * 100 / x);
    }

    /** 이분 탐색 수행 */
    static int binarySearch() {
        int start = 0;
        int end = MAX_GAME_COUNT;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (getWinRate(X + mid, Y + mid) != Z) {
                result = mid;
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()); // 게임 횟수 X 입력
        Y = Integer.parseInt(st.nextToken()); // 이긴 게임 횟수 Y 입력
        Z = getWinRate(X, Y);

        // 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 출력
        System.out.println(binarySearch());
    }
}
