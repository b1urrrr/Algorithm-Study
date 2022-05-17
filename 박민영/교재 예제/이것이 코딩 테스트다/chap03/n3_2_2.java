// chap03 (2) 실전문제 : 큰 수의 법칙

// 해설 코드 참고한 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n3_2_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬
        int first = arr[N-1];  // 가장 큰 수
        int second = arr[N-2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (M / (K + 1)) * K;
        cnt += M % (K + 1);

//        [반복되는 수열에 대해 파악하기]
//        (가장 큰 수)를 K번 더하고 (두 번째로 큰 수) 1개 더함 --> 반복되는 수열의 길이 : K + 1
//        따라서 수열이 반복되는 횟수 : M / (K + 1)
//        가장 큰 수가 등장하는 횟수 : (M / (K + 1)) * K
//        나누어떨어지지 않는 경우 고려 --> M % (K + 1)도 더해주어야 (가장 큰 수)를 몇 번 더 더해야 하는지를 구할 수 있음
//        따라서 cnt = (M / (K + 1)) * K + M % (K + 1)


        int sum = 0;
        sum += cnt * first; // 가장 큰 수 더하기
        sum += (M - cnt) * second; // 두 번째로 큰 수 더하기
        System.out.println(sum);
    }
}
