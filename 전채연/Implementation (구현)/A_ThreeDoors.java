import java.io.*;
import java.util.StringTokenizer;

public class A_ThreeDoors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        TEST : for (int test = 0; test < t; test++) {
            int x = Integer.parseInt(br.readLine()); // 내가 가진 열쇠 번호
            boolean[] doors = new boolean[4];
            int[] keys = new int[4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 3; i++) {
                keys[i] = Integer.parseInt(st.nextToken()); // i번 문 뒤에 있는 열쇠 번호
            }

            // 첫 번째 열쇠 사용
            doors[x] = true; // 문 열기
            if (keys[x] == 0) { // 문 뒤에 열쇠가 없는 경우
                System.out.println("NO");
                continue;
            } else {
                int temp = x;
                x = keys[x];
                keys[temp] = 0;
            }

            // 두 번째 열쇠 사용
            if (keys[x] == 0) { // 이미 열었던 문이거나 문 뒤에 열쇠가 없는 경우
                System.out.println("NO");
                continue;
            } else {
                doors[x] = true;
                int temp = x;
                x = keys[x];
                keys[temp] = 0;
            }

            // 세 번째 열쇠 사용
            doors[x] = true;
            for (int i = 1; i <= 3; i++) {
                if (!doors[x]) {
                    System.out.println("NO");
                    continue TEST;
                }
            }
            System.out.println("YES");
        }
    }
}
