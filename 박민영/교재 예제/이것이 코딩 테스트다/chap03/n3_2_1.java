// 내가 푼 것(해설 원리 조금 파악하고 풀었음)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n3_2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int first = 0;
        int second = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (first <= arr[i]) { // 이렇게 일일이 비교하면서 first, second를 찾는 방법보다 정렬한 후에 바로 찾는 방법이 더 간편!
                int temp = first;
                first = arr[i];
                second = temp;
                continue;
            }
            if (second <= arr[i]) {
                second = arr[i];
            }
        }

        int count = 0;
        int sum = 0;
        // 이런 방법의 경우, M의 크기가 커지면 시간 초과가 뜰 것임. 가장 큰 수가 더해지는 횟수 계산 면에서 교재 설명처럼 반복되는 수열을 이용한 아이디어가 필요함
        while (count < M) {
            for (int i = 0; i < K && count < M; i++) {
                sum += first;
                count++;
            }
            if (count < M) {
                sum += second;
                count++;
            }
        }

        System.out.println(sum);
    }
}
