// chap07 (2) 실전 문제 : 부품 찾기 (내가 푼 코드 - 이진탐색 재귀로 구현) (예제 코드 조금 참고함)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n7_5_1 {
    static int[] have;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        have = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] want = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            want[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(have);

        for (int want_num : want) {
            if (binarySearch(0, n-1, want_num) == -1)
                System.out.print("no ");
            else
                System.out.print("yes ");
        }
    }

    static int binarySearch(int start, int end, int want_num) {
        if (start > end) return -1;  // 재귀로 구현할 때 종료 조건은 start > end 인 경우라는 걸 명심하자
        int mid = (start + end) / 2;

        if (have[mid] == want_num) {
            return mid;
        } else if (have[mid] < want_num) {
            return binarySearch(mid + 1, end, want_num);  // 재귀 값을 리턴하도록 해야 함!
        } else
            return binarySearch(start, mid - 1, want_num);


//        // 반복문으로 구현하기
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (have[mid] == want_num) return mid;
//            else if (have[mid] > want_num) end = mid - 1;
//            else start = mid + 1;
//        }
//        return -1;
    }


}
