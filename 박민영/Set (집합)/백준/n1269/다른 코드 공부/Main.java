/*
 * @author Minyeong Park
 * @date 2022.06.02.
 * 대칭 차집합 (다른 코드 공부)
 * 참고 출처 : https://codeung.tistory.com/308
 * 문제 링크 : https://www.acmicpc.net/problem/1269
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a_count = Integer.parseInt(st.nextToken());
        int b_count = Integer.parseInt(st.nextToken());

        HashSet<Integer> a = new HashSet<Integer>();
        HashSet<Integer> b = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a_count; i++) {
            int num = Integer.parseInt(st.nextToken());
            a.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b_count; i++) {
            int num = Integer.parseInt(st.nextToken());
            b.add(num);
        }

        int count = 0;
        for (int num : a) {
            if (!b.contains(num))
                count++;
        }
        for (int num : b) {
            if (!a.contains(num))
                count++;
        }
        System.out.println(count);
    }
}