// chap04 (3) 실전 문제 : 게임 개발 (내가 푼 것은 틀려서.. 해설 코드 참고해서 이해하면서 해결함)
// 캐릭터 움직임 매뉴얼 3번을 고려했어야 했는데 안 해서.. 이 해설 코드처럼, turn_time이라는 변수를 만들어서 각 방향에 대한 정보를 담아야 한다.
// 그리고 dx, dy 리스트를 따로 만들어서, 미리 방향을 정하는 것이 효과적이다.
// 이 dx,dy를 이용해 움직여본 후 정면에 가보지 않은 칸이 존재하는지를 판단해야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n4_4 {
    public static int n, m, x, y, direction;

    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];

    // 전체 맵 정보
    public static int[][] arr = new int[50][50];

    // 북, 동, 남, 서 방향 정의
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1)
            direction = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시뮬레이션 시작
        int count = 1;
        int turn_time = 0;
        while (true) {
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우, 이동
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                count += 1;
                turn_time = 0;
                continue;
            }
            else  // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다의 경우
                turn_time += 1;

            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                else // 뒤가 바다로 막혀 있는 경우
                    break;
                turn_time = 0;
            }
        }
        System.out.println(count);
    }
}
