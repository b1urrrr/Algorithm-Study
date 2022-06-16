// chap07 (2) 실전 문제 : 부품 찾기 (해설 코드 2 - 계수 정렬)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n7_5_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] have = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            have[x] = 1;
        }

        int m = Integer.parseInt(br.readLine());
        int[] want = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            want[i] = Integer.parseInt(st.nextToken());
        }

        for (int want_num : want) {
            // 해당 부품이 존재하는지 확인
            if (have[want_num] == 1)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
}
