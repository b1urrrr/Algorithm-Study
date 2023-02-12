/*
    백준 1316번 : 그룹 단어 체커
    - 문제 유형 : 구현, 문자열
*/

import java.util.Scanner;

public class 그룹_단어_체커 {
    public static void main(String[] main) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt(); // 단어의 개수 N 입력
        int[] alpha = new int[26];
        int answer = 0;

        for (int i = 0; i < repeat; i++) {
            for (int j = 0; j < alpha.length; j++) {
                alpha[j] = 0;
            }
            boolean isGroup = true;
            String word = sc.next(); // 단어 입력
            char curAlpha = '\n';
            for (int j = 0; j < word.length(); j++) {
                if (curAlpha == word.charAt(j)) continue;
                curAlpha = word.charAt(j);
                if (alpha[word.charAt(j) - 97] == 1) {
                    isGroup = false;
                    break;
                }
                alpha[word.charAt(j) - 97]++;
            }
            if (isGroup) answer++;
        }

        // 그룹 단어 개수 출력
        System.out.print(answer);

        sc.close();
    }
}