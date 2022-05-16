// chap03 (3) 실전문제 : 숫자 카드 게임

// 내가 푼 것
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n3_4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int select_min = 0;
        for (int i = 0; i < N; i++) {
            int min = arr[i][0];
            for (int j = 1; j < M; j++) {
                if (min > arr[i][j])
                    min = arr[i][j];
            }
            if (select_min < min)
                select_min = min;
        }
        System.out.println(select_min);
    }
}
