/*
 * @author Minyeong Park
 * @date 2022.11.13.
 * 단어 나누기
 * 원리 및 코드 참고 : https://blackvill.tistory.com/80
 * 문제 링크 : https://www.acmicpc.net/problem/1251
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList<String> list = new ArrayList();

        String[] st = new String[3];
        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                st[0] = str.substring(0, i);
                st[1] = str.substring(i, j);
                st[2] = str.substring(j);

                StringBuffer sb = new StringBuffer();

                // 쪼개진 문자열을 부분부분 뒤집기
                for (int k = 0; k < 3; k++) {
                    for (int l = st[k].length() - 1; l >= 0; l--) {
                        sb.append(st[k].charAt(l));
                    }
                }

                // 문자열을 list에 추가
                list.add(sb.toString());
                sb.setLength(0);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));

    }
}