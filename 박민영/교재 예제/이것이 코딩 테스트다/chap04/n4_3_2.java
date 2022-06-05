// chap04 (2) 실전 문제 : 왕실의 나이트 (해설 코드 참고해서 수정)
// 참고 1 : char - '0'에 대해서 - https://cokes.tistory.com/80
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n4_3_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String location = br.readLine();

        int col = location.charAt(0) - 'a' + 1;
        int row = location.charAt(1) - '0';     // 그냥 charAt(1)까지만 하면 아스키코드로 변환되어서 나옴. 따라서 '0'을 빼주어서 알맞은 행 결과로 나오게 함.

        // 나이트가 이동할 수 있는 8가지 방향 정의
        // 수평 -2칸 & 수직 -1칸 , 수직 -2칸 & 수직 -1칸... 이런 쌍을 각각의 배열에 담은 것임.
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int count = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8) {
                count++;
            }
        }
        System.out.println(count);
    }
}
