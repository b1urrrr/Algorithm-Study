/*
    백준 2941번 : 크로아티아 알파벳
    - 문제 유형 : 구현, 문자열
*/

import java.util.Scanner;

public class 크로아티아_알파벳 {
    public static void main(String[] main) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next(); // 단어 입력
        int answer = word.length();

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == 'z' && word.charAt(i+1) == '=') answer--;
            if (word.charAt(i) == 'c' && word.charAt(i+1) == '=') answer--; 
            if (word.charAt(i) == 'c' && word.charAt(i+1) == '-') answer--; 
            if (word.charAt(i) == 'd' && word.charAt(i+1) == '-') answer--; 
            if (word.charAt(i) == 'l' && word.charAt(i+1) == 'j') answer--; 
            if (word.charAt(i) == 'n' && word.charAt(i+1) == 'j') answer--; 
            if (word.charAt(i) == 's' && word.charAt(i+1) == '=') answer--; 
        }

        for (int i = 0; i < word.length() - 2; i++) {
            if (word.charAt(i) == 'd' && word.charAt(i + 1) == 'z' && word.charAt(i + 2) == '=') answer--;
        }
        
        // 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력
        System.out.print(answer);

        sc.close();
    }
}