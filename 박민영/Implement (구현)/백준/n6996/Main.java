/*
 * @author Minyeong Park
 * @date 2022.12.11.
 * 애너그램     // 내가 푼 건데 33%에서 계속 틀렸습니다가 뜬다. 반례를 다 돌려봐도 맞게 나오는데 왜 틀렸는지 잘 모르겠다... 다시 보기
 * 문제 링크 : https://www.acmicpc.net/problem/6996
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken().toLowerCase();
            String b = st.nextToken().toLowerCase();

            ArrayList<Character> arr = new ArrayList<Character>();
            for (int j = 0; j < a.length(); j++) {
                arr.add(a.charAt(j));
            }

            if (a.length() != b.length()) {
                System.out.println(a + " & " + b + " are NOT anagrams.");
                continue;
            }

            for (int j = 0; j < b.length(); j++) {
                for (int k = 0; k < arr.size(); k++) {
                    if (arr.get(k) == b.charAt(j)) {
                        arr.remove(k);
                    }
                }
            }

            if (arr.size() > 0) {
                System.out.println(a + " & " + b + " are NOT anagrams.");
            } else {
                System.out.println(a + " & " + b + " are anagrams.");
            }
        }
    }
}