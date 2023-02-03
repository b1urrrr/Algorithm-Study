/*
 * @author Minyeong Park
 * @date 2023.02.04.
 * 비밀번호 찾기
 * 문제 링크 : https://www.acmicpc.net/problem/17219
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            map.put(key, value);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String find_key = br.readLine();
            sb.append(map.get(find_key)).append("\n");
        }
        System.out.println(sb);
    }
}