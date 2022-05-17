// chap03 (4) 실전문제 : 1이 될 때까지

// 내가 푼 것은 틀리게 구현한거라 해설보고 이해하면서 코드를 수정하였음
// 간단하게 푸는 답안 예시
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n3_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        // N이 K 이상이라면 K로 계속 나누기
        while (N >= K) {
            // N이 K로 나누어 떨어지지 않는다면 N에서 1씩 빼기
            while (N % K != 0) {
                N -= 1;
                count++;
            }

            // K로 나누기
            N = N / K;
            count++;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        // N이 이제 K보다 작은 수가 되었으므로 나누기는 불가능하기 때문에 계속 1씩 빼줌
        while (N > 1) {
            N -= 1;
            count++;
        }
        System.out.println(count);
    }
}
