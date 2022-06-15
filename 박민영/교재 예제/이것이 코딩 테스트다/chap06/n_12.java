// chap06 (4) 실전 문제 : 두 배열의 원소 교체
// 처음에 틀리게 구현했으나.. 해설 코드 조금 보면서 수정함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class n_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        Integer[] b = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        int index = 0;
        while (count < k && index < n) {
            if (a[index] < b[index]) { // b를 내림차순 정렬했으므로 그냥 index 자리값으로 비교해도 됨
                int temp = a[index];
                a[index] = b[index];
                b[index] = temp;
                count++;
                index++;
            } else
                break;
        }

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            System.out.println(a[i]);
        }
        System.out.println(sum);
    }
}
