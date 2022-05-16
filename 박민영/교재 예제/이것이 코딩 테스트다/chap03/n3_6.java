// chap03 (4) 실전문제 : 1이 될 때까지

// 답안 예시 코드 보면서 수정함 (N >= 100억 이상일 경우에도 빠르게 동작하는 코드)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n3_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        while (true) {
            // (N == K로 나누어떨어지는 수)가 될 때까지 N에서 1씩 빼기
            int target = (N / K) * K; // K로 나누어떨어지는 수
            count += N - target;      // count에 N - K로 나누어떨어지는 수를 한 방에 더함으로써 1씩 빼는 과정을 단축함
            N = target;               // 1씩 빼준 후의 N값

            // N이 K보다 작을 때 (더이상 나눌 수 없을 때) 반복문 탈출
            if (N < K)
                break;

            // K로 나누기
            count++;
            N /= K;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        count += N - 1;
        System.out.println(count);
    }
}
