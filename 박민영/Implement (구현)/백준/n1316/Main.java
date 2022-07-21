/*
 * @author Minyeong Park
 * @date 2022.07.21.
 * 그룹 단어 체커
 * 원리 참고 : https://st-lab.tistory.com/69
 * 문제 링크 : https://www.acmicpc.net/problem/1316
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Character> ch_list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.println(count);
    }
    static boolean check() throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i); // i번째 문자 저장(현재 문자)

            // 앞선 문자와 i번째 문자가 같지 않다면?
            if (prev != now) {
                if (check[now - 'a'] == false) { // 해당 문자가 처음 나오는 경우
                    check[now - 'a'] = true;
                    prev = now; // 다음 턴을 위해 prev도 변경
                } else {
                    return false;
                }
            } else { // 앞선 문자와 i번째 문자가 같다면 (연속된 경우)
                continue;
            }
        }
        return true;
    }
}