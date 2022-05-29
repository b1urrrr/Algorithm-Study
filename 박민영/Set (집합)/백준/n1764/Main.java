/*
 * @author Minyeong Park
 * @date 2022.05.29.
 * 듣보잡
 * 참고 : https://godog.tistory.com/entry/Java-HashSet-%ED%95%A9%EC%A7%91%ED%95%A9-%EC%B0%A8%EC%A7%91%ED%95%A9-%EA%B5%90%EC%A7%91%ED%95%A9-%EB%B6%80%EB%B6%84%EC%A7%91%ED%95%A9
 * 문제 링크 : https://www.acmicpc.net/problem/1764
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> no_hear = new HashSet();
        for (int i = 0; i < n; i++) {
            no_hear.add(br.readLine());
        }
        HashSet<String> no_see = new HashSet();
        for (int i = 0; i < m; i++) {
            no_see.add(br.readLine());
        }

        int count = 0;
        no_hear.retainAll(no_see); // 교집합 구하기

        String[] list = new String[no_hear.size()]; // 듣도 보도 못한 이름들을 담는 배열
        for (String str : no_hear) {
            list[count] = str;
            count++;
        }

        Arrays.sort(list); // 배열 정렬
        System.out.println(count);
        for (String str : list) {
            System.out.println(str);
        }
    }
}