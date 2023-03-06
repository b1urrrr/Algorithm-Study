/*
 * @author Minyeong Park
 * @date 2023.03.05.
 * 팰린드롬인지 확인하기
 * 문제 링크 : https://www.acmicpc.net/problem/10988
 */



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        boolean is_p = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                is_p = false;
                break;
            }
        }

        System.out.println(is_p ? 1 : 0);
    }
}