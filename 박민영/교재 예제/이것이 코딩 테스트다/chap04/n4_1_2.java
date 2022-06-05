// chap04 (1) 예제 4-1 : 상하좌우 (교재 답안 코드 참고해서 수정)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class n4_1_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int row = 1;
        int col = 1;

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;

            for (int j = 0; j < 4; j++) {
                 if (plan == moveTypes[j]) {
                     nx = row + dx[j];
                     ny = col + dy[j];
                 }
            }

            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
            // 벗어나지 않는 경우, 이동 수행
            row = nx;
            col = ny;
        }

        System.out.println(row + " " + col);
    }
}
