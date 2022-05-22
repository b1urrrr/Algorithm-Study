/*
 * @author Minyeong Park
 * @date 2022.05.22.
 * 문자열 집합
 * 참고 : https://coding-factory.tistory.com/554
 * 문제 링크 : https://www.acmicpc.net/problem/14425
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> S = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }
        String[] test = new String[M];
        for (int i = 0; i < M; i++) {
            test[i] = br.readLine();
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            if (S.contains(test[i]))
                count++;
        }
        System.out.println(count);
    }
}