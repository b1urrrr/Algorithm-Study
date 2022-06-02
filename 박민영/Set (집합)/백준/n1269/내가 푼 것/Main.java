/*
 * @author Minyeong Park
 * @date 2022.06.02.
 * 대칭 차집합
 * 참고 : https://godog.tistory.com/entry/Java-HashSet-%ED%95%A9%EC%A7%91%ED%95%A9-%EC%B0%A8%EC%A7%91%ED%95%A9-%EA%B5%90%EC%A7%91%ED%95%A9-%EB%B6%80%EB%B6%84%EC%A7%91%ED%95%A9
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
        HashSet temp_a = new HashSet(); // a 복사본
        HashSet temp_b = new HashSet(); // b 복사본

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a_count; i++) {
            int num = Integer.parseInt(st.nextToken());
            a.add(num);
            temp_a.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b_count; i++) {
            int num = Integer.parseInt(st.nextToken());
            b.add(num);
            temp_b.add(num);
        }

        temp_a.removeAll(b);
        temp_b.removeAll(a);

        System.out.println(temp_a.size() + temp_b.size());
    }
}