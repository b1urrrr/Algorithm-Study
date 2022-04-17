package chap08.practice;

import java.util.Scanner;

public class Practice8_2 {
    static int bfMatchLast(String txt, String pat) {
        int pt = 0;
        int pp = 0;

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length())
            return pt - pp + pat.length();
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatchLast(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for (int i = 0; i < idx - s2.length(); i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println(idx + "번째 문자까지 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("  패턴 : %%%ds\n", len), s2);
        }
    }    
}
