// chap07 (2) 실전 문제 : 부품 찾기 (해설 코드 3 - set 이용하기)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class n7_5_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            s.add(x);
        }

        int m = Integer.parseInt(br.readLine());
        int[] want = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            want[i] = Integer.parseInt(st.nextToken());
        }

        for (int want_num : want) {
            // 해당 부품이 존재하는지 확인
            if (s.contains(want_num))
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
}
