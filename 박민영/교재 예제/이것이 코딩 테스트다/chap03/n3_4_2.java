// chap03 (3) 실전문제 : 숫자 카드 게임

// 교재에서 2중 반복문을 이용하는 답안 예시
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n3_4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        // 한 줄씩 입력 받아 확인
        for (int i = 0; i < N; i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                min_value = Math.min(min_value, x);
                System.out.println(i + " " + j + " : " + min_value);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value); // 이전 행에서도 진행하고 가장 컸던 result와 현재 줄의 min_value를 비교
        }

        System.out.println(result);
    }
}
