// chap11 Q4. 만들 수 없는 금액 (모르겠어서.. 해설 코드 참고)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n11_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);

        int target = 1;
        for (int i = 0; i < n; i++) {
            // 만들 수 없는 금액을 찾았을 때(target보다 더 큰 화폐 단위가 있는 경우) 반복 종료
            if (target < arrayList.get(i)) break;
            target += arrayList.get(i); // target까지의 모든 금액을 만들 수 있다
        }
        System.out.println(target);
    }
}
