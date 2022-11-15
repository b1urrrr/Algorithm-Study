import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n15_29 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;      // 가능한 최소 거리(min gap)
        int end = arr[n-1] - arr[0]; // 가능한 최대 거리(max gap)
        int result = 0;


        while (start <= end) {
            int mid = (start + end) / 2; // mid : 가장 인접한 두 공유기 사이의 거리

            int value = arr[0]; // 첫째 집에는 무조건 공유기를 설치한다고 가정
            int cnt = 1;

            // 현재의 mid값을 이용해 공유기를 설치하기
            for (int i = 1; i < n; i++) {
                if (arr[i] - value >= mid) {
                    value = arr[i];
                    cnt++;
                }
            }

            // c개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
            if (cnt >= c) {
                start = mid + 1;
                result = mid; // 최적의 결과를 저장
            }
            // c개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}