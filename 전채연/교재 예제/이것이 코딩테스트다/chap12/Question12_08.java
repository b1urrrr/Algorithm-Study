package chap12;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Question12_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 문자열 S 입력

        int sum = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            // 숫자는 합산
            if (S.charAt(i) <= '9') sum += S.charAt(i) - '0';
            // 알파벳은 리스트에 추가
            else list.add(S.charAt(i));
        }
        
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println(sum);
    }    
}
